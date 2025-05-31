#!/bin/bash

CONTAINER='inventory'

podman run -ti --rm \
    -e _JAVA_OPTIONS='-Dawt.useSystemAAFontSettings=lcd -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel' \
    -e DISPLAY=:0 \
    -e XDG_RUNTIME_DIR=/tmp \
    -e WAYLAND_DISPLAY=$WAYLAND_DISPLAY \
    -v /tmp/.X11-unix:/tmp/.X11-unix \
    -v /run/user/$(id -u):/tmp \
    --security-opt label=type:container_runtime_t \
    --network=host \
    "${CONTAINER}"
