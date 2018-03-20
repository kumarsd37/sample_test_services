package com.rev.etl.faker;

import com.rev.etl.faker.configurations.ServiceConfiguration;
import com.rev.etl.faker.dao.OrderDAO;
import com.rev.etl.faker.entities.Item;
import com.rev.etl.faker.entities.Order;
import com.rev.etl.faker.resources.SampleOrderResource;
import com.rev.etl.faker.utils.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class ServiceApplication extends Application<ServiceConfiguration> {

    private final static Logger logger = LoggerFactory.getLogger(ServiceApplication.class.getSimpleName());

    public static void main(String[] args) {
        try {
            new ServiceApplication().run(args);
        } catch (Exception e) {
            logger.error("Error running application", e);
        }
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {

    }

    @Override
    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {


        Path temp = Files.createTempFile("ComputerPeripheralsItemList-","xlsx");
        Files.copy(ServiceApplication.class.getClass().getResourceAsStream("/ComputerPeripheralsItemList.xlsx"), temp, StandardCopyOption.REPLACE_EXISTING);
        FileInputStream fileInputStream = new FileInputStream(temp.toFile());

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Item> itemsList = new ArrayList<Item>();
        for(int i = 1; i< sheet.getLastRowNum() ; i++){
            Row row = sheet.getRow(i);
            Item item = new Item(row.getCell(2).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(0).getStringCellValue(),
                    row.getCell(9).getNumericCellValue()
                    );
            itemsList.add(item);
        }

        String ipAddress = InetAddress.getLocalHost().getHostAddress();

        // create orders dao object
        OrderDAO orderDAO = new OrderDAO(itemsList, ipAddress);

        JAXBContext contextObj = JAXBContext.newInstance(Order.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        SampleOrderResource sampleOrderResource = new SampleOrderResource(orderDAO, marshallerObj);
        environment.jersey().register(sampleOrderResource);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck();
        environment.healthChecks().register("healthCheck", healthCheck);

        //Create Filter and  Configure CORS parameters
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
