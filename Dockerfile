FROM maven:3-jdk-17

RUN apt-get update && apt-get install -y --no-install-recommends \
		openjfx \
	&& rm -rf /var/lib/apt/lists/*