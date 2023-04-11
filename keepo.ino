int S0  = 5;
int S1  = 4;
int S2  = 3;
int S3  = 2;

int En0 = 7;
int En1 = 6;
 
int controlPin[] = {S0,S1,S2,S3,En0,En1};
 
int ADC_pin = A3; // Arduino ProMicro : A3, Arduino NANO : A7
 
const int NUM_OF_CH = 32;
int sensor_data[NUM_OF_CH];
 
 
 
void setup() {
  pinMode(En0, OUTPUT);
  pinMode(En1, OUTPUT);
 
  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT); 
  
  Serial.begin(115200);
}
 
 
void loop() { 
  
  for(int ch = 0 ; ch < NUM_OF_CH ; ch++){ 
    sensor_data[ch] = readMux(ch);
  }
 
 
  //  print to serial port
  for(int ch = 0; ch < NUM_OF_CH; ch++){ 
    Serial.print(sensor_data[ch]);
    Serial.print(",");  // comma is used as a delimiter.
  }
  Serial.println(" ");  // end of line. carriage return.
 
  delay(10); // sleep for 10 milli seconds. It slow down the speed. You can delete this line.
}
 
 
int readMux(int channel){
 
  int muxChannel[NUM_OF_CH][6]={ //  6 means number of digital control pins for 2 mux ic.
    //  {S0,S1,S2,S3,En0,En1}
    {0,0,0,0,0,1}, //channel 0. '0': pin out low, 1 : pin out high. 
    {0,0,0,1,0,1}, //channel 1 It means S0=0, S1=0, S2=0, S3=1, En0=0, En1=1
    {0,0,1,0,0,1}, //channel 2
    {0,0,1,1,0,1}, //channel 3
    {0,1,0,0,0,1}, //channel 4
    {0,1,0,1,0,1}, //channel 5
    {0,1,1,0,0,1}, //channel 6
    {0,1,1,1,0,1}, //channel 7
    {1,0,0,0,0,1}, //channel 8
    {1,0,0,1,0,1}, //channel 9
    {1,0,1,0,0,1}, //channel 10
    {1,0,1,1,0,1}, //channel 11
    {1,1,0,0,0,1}, //channel 12. It means S0=1, S1=1, S2=0, S3=0, En0=0, En1=1
    {1,1,0,1,0,1}, //channel 13
    {1,1,1,0,0,1}, //channel 14
    {1,1,1,1,0,1}, //channel 15
    {0,0,0,0,1,0}, //channel 16
    {0,0,0,1,1,0}, //channel 17
    {0,0,1,0,1,0}, //channel 18
    {0,0,1,1,1,0}, //channel 19
    {0,1,0,0,1,0}, //channel 20
    {0,1,0,1,1,0}, //channel 21. It means S0=0, S1=1, S2=0, S3=1, En0=1, En1=0
    {0,1,1,0,1,0}, //channel 22
    {0,1,1,1,1,0}, //channel 23
    {1,0,0,0,1,0}, //channel 24
    {1,0,0,1,1,0}, //channel 25
    {1,0,1,0,1,0}, //channel 26
    {1,0,1,1,1,0}, //channel 27
    {1,1,0,0,1,0}, //channel 28
    {1,1,0,1,1,0}, //channel 29
    {1,1,1,0,1,0}, //channel 30
    {1,1,1,1,1,0}  //channel 31
  };
 
 
  for(int i = 0; i < 6; i ++){
    digitalWrite(controlPin[i], muxChannel[channel][i]);
  }
 
  //read sensor value
  int adc_value = analogRead(ADC_pin);
 
  return adc_value;
}
