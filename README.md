# Sample Orders

* sample orders generate the random order json/xml, which consists of
shipping address and Line items.

#### How to run

```bash
java -jar sample-orders-1.0-SNAPSHOT.jar server services-api.yml
```

##### API
```
GET /services/sampleorders - will return json data by default

params:
    format=xml  - optional
```

* sample order in json:
```json
{"order": {
    "Address": {
        "zipcode": "14014-8931",
        "firstName": "Tiana",
        "lastName": "Bergstrom",
        "country": "Honduras",
        "phoneNumber": "(460) 913-3122",
        "city": "Schadenfurt",
        "latitude": 45.693674,
        "streeAddress": "649 Tod Ridges",
        "longitude": 127.72078
    },
    "Items": {"Item": [
        {
            "quantity": 3,
            "price": 23990,
            "name": "27\" AH-IPS HDMI/MHLN/Nar Bezel",
            "id": "T00007",
            "category": "Desktops & Monitors"
        },
        {
            "quantity": 2,
            "price": 99890,
            "name": "Asus ROG G551VW-FI242T 90NB0AH2-M02910 Core i7 (6th Gen)",
            "id": "T00006",
            "category": "Laptops"
        },
        {
            "quantity": 16,
            "price": 21490,
            "name": "HP 15.6-inch Laptop",
            "id": "T00005",
            "category": "Laptops"
        },
        {
            "quantity": 4,
            "price": 10123,
            "name": "AOC 23 inch IPS LED Monitor",
            "id": "T00011",
            "category": "Desktops & Monitors"
        },
        {
            "quantity": 4,
            "price": 10123,
            "name": "AOC 23 inch IPS LED Monitor",
            "id": "T00011",
            "category": "Desktops & Monitors"
        },
        {
            "quantity": 6,
            "price": 29990,
            "name": "Lenovo G G50-80 80E502Q3IH Core i3 (5th Gen)",
            "id": "T00004",
            "category": "Laptops"
        },
        {
            "quantity": 17,
            "price": 840,
            "name": "Easy Wireless Keyboard with wireless mouse combo",
            "id": "T00033",
            "category": "Computer Accessories"
        }
    ]},
    "order_time": "2018-03-20T13:04:10.826+05:30",
    "order_id": "BLKYLS4QAAHYCGAAD"
}}
```

* sample order in xml:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<order order_id="BLKYL34QAAHYCGAAB" order_time="2018-03-20T13:23:22.066+05:30">
    <Address>
        <firstName>Elta</firstName>
        <lastName>Cole</lastName>
        <streeAddress>1277 Gerlach Fall</streeAddress>
        <city>East Janice</city>
        <country>Kiribati</country>
        <zipcode>28421-8855</zipcode>
        <phoneNumber>(168) 898-4605</phoneNumber>
        <longitude>59.378064</longitude>
        <latitude>-64.208963</latitude>
    </Address>
    <Items>
        <Item id="T00013">
            <name>Lenovo 19.5-inch Desktop</name>
            <category>Desktops &amp; Monitors</category>
            <price>39990.0</price>
            <quantity>9</quantity>
        </Item>
        <Item id="T00014">
            <name>Lenovo 4th Gen</name>
            <category>Desktops &amp; Monitors</category>
            <price>37990.0</price>
            <quantity>19</quantity>
        </Item>
        <Item id="T00008">
            <name>AOC 22 inch Monitor</name>
            <category>Desktops &amp; Monitors</category>
            <price>9999.0</price>
            <quantity>7</quantity>
        </Item>
        <Item id="T00012">
            <name>Asus Desktop</name>
            <category>Desktops &amp; Monitors</category>
            <price>24990.0</price>
            <quantity>17</quantity>
        </Item>
        <Item id="T00020">
            <name>HP v160w 16GB Pen Drive</name>
            <category>Pen Drives</category>
            <price>456.0</price>
            <quantity>5</quantity>
        </Item>
        <Item id="T00023">
            <name>HP DeskJet Ink Advantage 3835 All-in-One Multi-function Printer</name>
            <category>Printers &amp; Inks</category>
            <price>5699.0</price>
            <quantity>3</quantity>
        </Item>
        <Item id="T00053">
            <name>SanDisk 32GB USB 2.0 Pen Drive 1+1</name>
            <category>Pen Drives</category>
            <price>900.0</price>
            <quantity>15</quantity>
        </Item>
        <Item id="T00029">
            <name>HP Wireless Mouse</name>
            <category>Computer Accessories</category>
            <price>600.0</price>
            <quantity>12</quantity>
        </Item>
        <Item id="T00030">
            <name>HP Wired Mouse</name>
            <category>Computer Accessories</category>
            <price>400.0</price>
            <quantity>16</quantity>
        </Item>
        <Item id="T00026">
            <name>Canon Pixma MG2577s All-in-One InkJet Printer</name>
            <category>Printers &amp; Inks</category>
            <price>2599.0</price>
            <quantity>17</quantity>
        </Item>
        <Item id="T00044">
            <name>Tp-Link Archer C8 AC1750 Wireless Dual Band Gigabit Router</name>
            <category>Networking &amp; Internet Devices</category>
            <price>7800.0</price>
            <quantity>20</quantity>
        </Item>
        <Item id="T00041">
            <name>Intex 2.1 Channel Multimedia Speakers</name>
            <category>Computer Accessories</category>
            <price>679.0</price>
            <quantity>7</quantity>
        </Item>
        <Item id="T00041">
            <name>Intex 2.1 Channel Multimedia Speakers</name>
            <category>Computer Accessories</category>
            <price>679.0</price>
            <quantity>7</quantity>
        </Item>
        <Item id="T00050">
            <name>Gift Card Rs.800</name>
            <category>Gift Card</category>
            <price>800.0</price>
            <quantity>7</quantity>
        </Item>
        <Item id="T00009">
            <name>Asus 23-inch LCD Monitor</name>
            <category>Desktops &amp; Monitors</category>
            <price>18500.0</price>
            <quantity>20</quantity>
        </Item>
        <Item id="T00028">
            <name>Canon PG-47 Ink Cartridge</name>
            <category>Printers &amp; Inks</category>
            <price>450.0</price>
            <quantity>2</quantity>
        </Item>
        <Item id="T00030">
            <name>HP Wired Mouse</name>
            <category>Computer Accessories</category>
            <price>400.0</price>
            <quantity>16</quantity>
        </Item>
        <Item id="T00016">
            <name>Seagate Backup Plus Slim</name>
            <category>Hard Drives</category>
            <price>13750.0</price>
            <quantity>2</quantity>
        </Item>
        <Item id="T00014">
            <name>Lenovo 4th Gen</name>
            <category>Desktops &amp; Monitors</category>
            <price>37990.0</price>
            <quantity>19</quantity>
        </Item>
    </Items>
</order>
```
