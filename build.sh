#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################

cd ./lab4/lab4-drivers/; sh ./build.sh; cd ..
cd ./lab4-f1teams/; sh ./build.sh; cd ..
cd ./lab4-gateway/; sh ./build.sh; cd ../..
cd ./lab5/lab5-angular/; sh ./build.sh; cd ..
