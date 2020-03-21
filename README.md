# Basics of deployment

1. Create a secret with VPS IP in Github. We use this in our workflow for scp.
2. Create an SSH Key on server that can access the server (scp needs this).
   a) Copy the private key to secrets in Github.
   b) Add public key to authorized secrets for root user.
3. Generate the known hosts fingerprint for the VPS and add it as secret:
   `ssh-keyscan -H ip`
4. Add Workflow to deploy a jar.
5. Add initial user
   ```
   adduser --system --no-create-home solipool
   chown -R solipool: /opt/solipool
   ```
