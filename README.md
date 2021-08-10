

# Observações

Teve que ser feito **Downgrade** do *Spring Boot Framework* e *Elasticsearch*:
em **build.gradle**

```
plugin {
	id 'org.springframework.boot' version '2.2.6.RELEASE' 
}
```

**build.gradle** *dependencies* para o Projeto: **Product catalog**

```
dependencies { 
	...
	//	Elastic Search
	implementation 'org.springframework.boot:spring-boot-starter-data-elasticsearch:2.4.0' 
	...
}
```



**Elasticsearch** é essencial para a aplicação 'rodar' o projeto **Product-catalog**, para isso, foi utilizado **Elasticsearch 7.5.2**, [Download](https://www.elastic.co/guide/en/elasticsearch/reference/7.5/getting-started-install.html). Para inicia-lo basta executar o arquivo .bat localizado no: **bin\elasticsearch.bat**

**Redis** é essencial para a aplicação do projeto **Shopping-cart**



# Dicas

**Prefira utilizar** o [Docker](https://medium.com/@prog.tiago/redis-instalando-via-docker-58cb1d2cfb3b), pois com ele é possível fazer uso do **ElasticSearch** e **Redis**, isolado, e caso precise desliga-lo, não prejudicara o sistema operacional, isso torna tudo muito mais prático.



## Docker 

Os arquivos contendo o **Elasticsearch** e **Redis**, já estão no arquivo **docker-compose.yml**.
Para instalar e executa-lós:

Comandos para utilizar no Terminal:

Na pasta que estiver o arquivo **docker-compose.yml** de **Shift + Rick-Click** > Opção: **Abrir Janela do PowerShell Aqui**. ou **Open command window here**
No **PowerShell** digite `dir`
Em seguida digite: `docker-compose up -d`



Outros comandos para o **Docker**:

- `docker ps` - Por padrão exibe apenas containers em execução;
- `docker stop [CONTAINER ID]` - Parar o contêiner especificado;
- `docker rm [CONTAINER ID]` - Remove o contêiner especificado;
- `docker-compose up -d` - Inicia os serviços listados no arquivo **docker-compose.yml**. 



Caso queira desligar o **VmMem**:

```
wsl --shutdown
```

Configurar o quanto **VmMem** usara de recurso do sistema: **[Configure global options with .wslconfig](https://docs.microsoft.com/en-us/windows/wsl/wsl-config#configure-global-options-with-wslconfig)**



[*]O Docker necessita do **Hyper-V** ou **Windows Hypervisor Platform** habilitado, com isso, não será possível fazer uso do **VMware**, **VirtualBox** ou **Emuladores Android**.

[*] Recomendo alterar o *Tipo de Inicialização* do **Docker Desktop Service** no **Service** do Windows, deixando ele em **Manual**.



# Referências

Pureinfotech. **How to shutdown WSL 2 Linux distros on Windows 10** - https://pureinfotech.com/shutdown-wsl-2-linux-distros-windows-10/

Medium por Tiago Silva. **Redis, instalação via Docker** - https://medium.com/@prog.tiago/redis-instalando-via-docker-58cb1d2cfb3b

TheWindowsClub. **Ways to open Command Prompt in a folder in Windows 10** - https://www.thewindowsclub.com/how-to-open-command-prompt-from-right-click-menu
