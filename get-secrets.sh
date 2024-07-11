#!/bin/bash
mkdir ./secrets
cat > ./secrets/secrets.yml <<EOF
#  this file pulls the secrets from the Secret Manager, output them in a file.
#  Your application will read the file at container runtime.
#  https://alessio-trivisonno.medium.com/injecting-secrets-in-gke-with-secret-manager-fd961bbeea73
secrets:
  postgres_password: "`gcloud secrets versions access latest --secret=POSTGRES_PASSWORD`"
  postgres_user: "`gcloud secrets versions access latest --secret=POSTGRES_USER`"
EOF