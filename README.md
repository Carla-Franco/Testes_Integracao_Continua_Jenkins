## Integração contínua com testes, utilizando Jenkins

Nesse curso, eu aprendi a criar um processo automatizado de integração e deploy contínuo CI/CD para a minha aplicação. Passei por vários processos de testes visando garantir que novas versões do meu produto entrem no ar de forma rápida e segura.

Adicionei ao processo de integração contínua testes unitários, de serviço e funcionais, utilizando ferramentas populares como JUnit, Rest Assured e Selenium (inclusive, para este último, configurando uma suíte para execução de testes paralelizados em um Grid criado pelo Docker). Também fiz análise de qualidade e cobertura de código testado, através do Sonarqube. Configurei o histórico dos testes e avisos sempre que houver problemas na minha construção.

Além disso, aprendi a estruturar meu processo em duas formas distintas, através de jobs do Jenkins do tipo Freestyle (que pode ser configurado tudo através da interface do Jenkins). E também criei um processo completo do tipo Pipeline, onde centralizei todo o processo em um script (Jenkinsfile) dinâmico e poderoso.

Contei também com o uso de ferramentas importantes e atuais como o Docker (e docker-compose), Spring Boot, Postgres, Tomcat e Selenium Grid.

O que foi realizado neste projeto:
* Configurei o Jenkins para fazer a integração contínua da minha aplicação
* Trabalhei com jobs do Jenkins do tipo Freestyle e Pipeline
* Integrei testes unitários ao processo de integração contínua
* Integrei testes de API Rest ao processo de integração contínua
* Integrei testes funcionais ao processo de integração contínua
* Configurei projetos JAVA para ter análises de código feitas pelo Sonarqube
* Utilizei o Quality Gate do Sonarqube para definir critérios de aceites na aplicação
* Criei ambientes e dependências utilizando o Docker e docker-compose
* Otimizei o tempo de execução de testes funcionais através do Selenium Grid em um ambiente criado pelo Docker

