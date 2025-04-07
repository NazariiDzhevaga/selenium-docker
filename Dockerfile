FROM bellsoft/liberica-openjdk-alpine:23.0.2-cds

# instal curl jq
RUN apk add curl jq

# workspace
WORKDIR /home/selenium-docker

# add the required files target/docker-resources
ADD target/docker-resources      ./
ADD runner.sh                    runner.sh

# ENVIRONMENT
# BROWSER
# HUB_HOST
# TEST_SUITE
# THREAD_COUNT
# Fix for windows
RUN dos2unix runner.sh

# Start the runner.sh
ENTRYPOINT sh runner.sh

