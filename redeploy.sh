set -e
export DOCKER_HOST="ssh://ubuntu@130.193.50.11"

mvn clean package
docker-compose build
docker-compose up -d
