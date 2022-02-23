do_deploy_append() {
  echo "dtoverlay=enc28j60" >>${DEPLOYDIR}/bootfiles/config.txt
  #FIXME workaround for not working sugrow-gpio!
  echo "gpio=4,17,18,22,23,24,27=op" >>${DEPLOYDIR}/bootfiles/config.txt
  echo "gpio=5,6,12,13,16,19,20,21=ip,pu" >>${DEPLOYDIR}/bootfiles/config.txt  
}
