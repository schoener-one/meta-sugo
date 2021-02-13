do_deploy_append() {
  echo "dtoverlay=moco-gpio" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
  echo "dtoverlay=enc28j60" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
  #FIXME workaround for not working moco-gpio!
  echo "gpio=4,17,18,22,23,24,25,27=op" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
  echo "gpio=5,6,12,13,16,19,20,21=ip,pu" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt  
}
