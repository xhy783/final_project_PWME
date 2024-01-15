#include <DHT22.h>

#define pinDHT 13
#define pinTEMT A0
#define interval 10000

unsigned long t0, t;

DHT22 dht22(pinDHT);

void setup() {
  Serial.begin(115200);
  t0 = t = millis();
}

void loop() {
  float temp = dht22.getTemperature();
  float h = dht22.getHumidity();
  int l = analogRead(pinTEMT);

  if (dht22.getLastError()!=dht22.OK){
    Serial.print("1");
  }

  t = millis();
  if ( t - t0 >= interval ){
    Serial.print("Now humidity is:"); Serial.println(h);
    Serial.print("Now temperature is:");Serial.println(temp);
    Serial.print("Now light level is:");Serial.println(l);
    t0 = t;
  }

}
