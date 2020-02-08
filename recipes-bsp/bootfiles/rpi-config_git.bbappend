do_deploy_append() {
  echo "dtoverlay=moco-gpio" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}
