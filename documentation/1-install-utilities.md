## Update the package repository and install necessary dependencies and utilities.

Let us create a command folder accessible from across the container

```bash
mkdir -p /cmd
```

Install common utilities

```bash
# Install common utilities and beautify the terminal
apk update
apk add --no-cache docker curl wget py-pip python3-dev libffi-dev openssl-dev gcc libc-dev make  zip bash openssl git mongodb-tools openssl git docker-compose zsh vim nano bash unzip
# Install zsh for a cool looking terminal with plugins auto-suggestions and syntax-highlighting
sh -c "$(curl -fsSL https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"

## Clone the zsh-autosuggestions repository into $ZSH_CUSTOM/plugins
git clone https://github.com/zsh-users/zsh-autosuggestions.git $ZSH_CUSTOM/plugins/zsh-autosuggestions
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git $ZSH_CUSTOM/plugins/zsh-syntax-highlighting
sed -i.bak 's/plugins=(git)/plugins=(git zsh-autosuggestions zsh-syntax-highlighting)/' ~/.zshrc

# Check docker-compose version
docker-compose --version
apk update

# Install kubectl
apk add --no-cache curl
curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
chmod +x ./kubectl
mv ./kubectl /usr/local/bin/kubectl

# Install helm
curl -LO https://get.helm.sh/helm-v3.7.2-linux-amd64.tar.gz
tar -C /tmp/ -zxvf helm-v3.7.2-linux-amd64.tar.gz
rm helm-v3.7.2-linux-amd64.tar.gz
mv /tmp/linux-amd64/helm /usr/local/bin/helm
chmod +x /usr/local/bin/helm

# Get Terraform

curl -o /tmp/terraform.zip -LO https://releases.hashicorp.com/terraform/1.5.5/terraform_1.5.5_linux_amd64.zip
unzip /tmp/terraform.zip
chmod +x terraform && mv terraform /usr/local/bin/
terraform

# Install kind to access the cluster
curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.17.0/kind-linux-amd64
chmod +x ./kind
mv ./kind /usr/local/bin/kind

# 4. Install ArgoCD CLI

curl -sSL -o argocd-linux-amd64 https://github.com/argoproj/argo-cd/releases/latest/download/argocd-linux-amd64
install -m 555 argocd-linux-amd64 /usr/bin/argocd
rm argocd-linux-amd64

# Test cluster

kubectl get nodes

# NAME STATUS ROLES AGE VERSION

# vault-control-plane Ready control-plane,master 37s v1.21.1
```

Deleting in Linux distros might prove dangerous, hence let us create a script to confirm before deleting:

```bash
cat << 'EOF' > /cmd/confirm_rm_rf.sh
#!/bin/sh
printf "Do you really wanna delete (yes/no) \n===>: "

# Reading the input from terminal
read answer

if [ $answer == "yes" ]
then
  rm -rf $@
elif [ "$answer" !=  "yes" ]
then
  printf "You didn't confirm!\nExiting, no action taken!"
fi
EOF
chmod +x /cmd/confirm_rm_rf.sh
cat /cmd/confirm_rm_rf.sh


# ---
cat << 'EOF' >> ~/.zshrc
source $ZSH/oh-my-zsh.sh
source $ZSH_CUSTOM/plugins/zsh-autosuggestions
source $ZSH_CUSTOM/plugins/zsh-syntax-highlighting

export PATH="$PATH:/cmd"
alias rm="confirm_rm_rf.sh"

EOF
cat ~/.zshrc

# To apply the changes, the auto-suggestions and syntax-highlighting plugins must be sourced:
source ~/.zshrc
zsh
```
