FROM python:3.10-slim

RUN apt -y update && \
    apt -y install default-jre git && \
    pip install launchable

ENTRYPOINT [ "launchable", "verify" ]
