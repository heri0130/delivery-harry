![image](https://github.com/heri0130/delivery-harry/assets/133316599/a415485c-d279-49a3-b877-f084974381d2)



![image](https://github.com/heri0130/delivery-harry/assets/103555301/1da1bb23-e732-45a1-80d3-f50ed8d312ec)



# 

## Model
www.msaez.io/#/storming/deliveryharry_1108

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- order
- payment
- storeOrder
- delivery


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- order
```
 http :8088/orderMgmts id="id" userId="userId" menuName="menuName" menuQty="menuQty" amount="amount" status="status" address="address" 
```
- payment
```
 http :8088/paymentMgmts id="id" amount="amount" userId="userId" orderId="orderId" status="status" 
```
- storeOrder
```
 http :8088/storeOrderMgmts id="id" userId="userId" menuName="menuName" menuQty="menuQty" orderId="orderId" payId="payId" amount="amount" status="status" 
```
- delivery
```
 http :8088/deliveryMgmts id="id" userId="userId" storeId="storeId" orderId="orderId" storeStatus="storeStatus" orderStatus="orderStatus" status="status" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

