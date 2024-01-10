#include <DHT22.h>
#include <WiFi.h>
#include <WebServer.h>

#define pinDHT 13
#define pinTEMT A3
#define interval 5000

unsigned long t0, t;

const char* ssid = "LAPTOP-IQTUJUFA 1050";
const char* password = "wzy1219988103";

WebServer server(80);

DHT22 dht22(pinDHT);

void setup() {
  Serial.begin(115200);
  t0 = t = millis();

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(5000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  server.on("/sensor-data", HTTP_GET, handleSensorData); 
  server.begin();
}

void loop(){
  float temp = dht22.getTemperature();
  float h = dht22.getHumidity();
  int ll = analogRead(pinTEMT);
  t = millis();
  if ( t - t0 >= interval ){
    Serial.print("Now humidity is:"); Serial.println(h);
    Serial.print("Now temperature is:");Serial.println(temp);
    Serial.print("Now light level is:");Serial.println(ll);
    t0 = t;
  }
 server.handleClient();
}

void handleSensorData(){
  float temp = dht22.getTemperature();
  float h = dht22.getHumidity();
  int ll = analogRead(pinTEMT);

  String message = "Temperature: " + String(temp) + " C, Humidity: " + String(h) + "%, Light Level: " + String(ll);
  server.send(200,"text/plain",message);
}


