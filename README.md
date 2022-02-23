# Sugo layer

This layer contains the core image (real-time) and system services.

## Boot config file

Within the config.txt file boot time configuration can be added.

### Gpio configuration

The keywork _gpio_ can be assigned by a list of GPIO pin numbers,
which should be configured in a specified way.

Example:
```
gpio=5,6,12,13,16,19,20,21=ip,pu
```
Special configuration keywords:

- ip - Pin als Eingang setzen
- op - Pin als Ausgang setzen
- a0-a5 - Umschaltung auf Alternativbelegung Alt0 bis Alt5
- dh - Ausgang auf HIGH setzen
- dl - Ausgang auf LOW setzen
- pu - Pullup-Widerstand einschalten
- pd - Pulldown-Widerstand einschalten
- pn - Kein Pullup-/Pulldown-Widerstand

## TODOs

1. Initialize the GPIOs in a synchronized way on boot and service start time.