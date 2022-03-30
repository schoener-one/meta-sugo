do_deploy_append() {
  #NOTE The enc28J60 driver uses gpio pin 25 as interrupt line!
  echo "dtoverlay=enc28j60" >>${DEPLOYDIR}/bootfiles/config.txt
  # ip - Pin als Eingang setzen
  # op - Pin als Ausgang setzen
  # a0-a5 - Umschaltung auf Alternativbelegung Alt0 bis Alt5
  # dh - Ausgang auf HIGH setzen
  # dl - Ausgang auf LOW setzen
  # pu - Pullup-Widerstand einschalten
  # pd - Pulldown-Widerstand einschalten
  # pn - Kein Pullup-/Pulldown-Widerstand
  echo "gpio=4,12,13,16,17,18,19,20,21,22,23,24,26,27=op,dl" >>${DEPLOYDIR}/bootfiles/config.txt  
  echo "gpio=5,6=ip" >>${DEPLOYDIR}/bootfiles/config.txt
}
