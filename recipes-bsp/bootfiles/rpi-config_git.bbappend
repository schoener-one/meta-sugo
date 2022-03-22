do_deploy_append() {
  #NOTE The enc28J60 driver uses gpio pin 25 as interrupt line!
  echo "dtoverlay=enc28j60" >>${DEPLOYDIR}/bootfiles/config.txt
  #FIXME workaround for not working sugrow-gpio!
  #echo "gpio=4,18,20,21,22,26=op" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "gpio=4,5,6,12,13,16,17,18,19,20,21,22,23,24,26,27=ip,pd" >>${DEPLOYDIR}/bootfiles/config.txt  
}
