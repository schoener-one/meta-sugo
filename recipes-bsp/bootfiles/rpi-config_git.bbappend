do_deploy:append() {
  #NOTE The enc28J60 driver uses gpio pin 25 as interrupt line!
  #echo "dtoverlay=enc28j60" >>${DEPLOYDIR}/bootfiles/config.txt
  # ip - Pin als Eingang setzen
  # op - Pin als Ausgang setzen
  # a0-a5 - Umschaltung auf Alternativbelegung Alt0 bis Alt5
  # dh - Ausgang auf HIGH setzen
  # dl - Ausgang auf LOW setzen
  # pu - Pullup-Widerstand einschalten
  # pd - Pulldown-Widerstand einschalten
  # pn - Kein Pullup-/Pulldown-Widerstand
  echo "# Enable soft I2C driver" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "dtoverlay=i2c-gpio,i2c_gpio_sda=2,i2c_gpio_scl=3,bus=3,i2c_gpio_delay_us=1" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "# GPIO default configuration" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "gpio=4,17,18,19,20,21,22,23,24,26,27=op" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "gpio=13=ip,pd" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "gpio=5,6,12,16=ip,pu" >>${DEPLOYDIR}/bootfiles/config.txt
}
