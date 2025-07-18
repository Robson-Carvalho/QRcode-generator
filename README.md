<h1 align="center">QR Code Generetor 📜</h1>
<div align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white" />
  <img src="https://img.shields.io/badge/Docker-2CA5E0?style=flat&logo=docker&logoColor=white" />
  <img src="https://img.shields.io/badge/Amazon_Web_Services-FF9900?style=flat&logo=amazonwebservices&logoColor=white" />
</div>

---

<div align="left">
  <h3>📖 Descrição</h3>

  <p>
    O <strong>QR Code Generator</strong> é uma API desenvolvida em Java com Spring Boot que permite gerar QR Codes a partir de textos enviados via requisição HTTP.
    O QR Code gerado é salvo automaticamente na AWS S3 e a URL pública da imagem é retornada como resposta da API.
  </p>

  <p>
    Esse projeto é útil para aplicações que desejam disponibilizar links, códigos ou mensagens em forma de QR Code de maneira automatizada e escalável, sem depender de bibliotecas frontend.
  </p>
</div>

<div align="left">
  <h3>🛠️ Tecnologias Utilizadas</h3>

  <ul>
    <li><strong>Java</strong> – Linguagem principal da aplicação</li>
    <li><strong>Spring Boot</strong> – Framework para desenvolvimento da API</li>
    <li><strong>ZXing</strong> – Biblioteca para geração de QR Codes</li>
    <li><strong>AWS S3</strong> – Armazenamento em nuvem das imagens geradas</li>
    <li><strong>Docker</strong> – Conteinerização da aplicação</li>
  </ul>
</div>

<div align="left">
  <h3>🚀 Como Executar</h3>

<h4>🔧 Pré-requisitos</h4>
  <ul>
    <li>Java 21 instalado</li>
    <li>Docker (opcional)</li>
    <li>Credenciais da AWS válidas</li>
  </ul>

<h4>▶️ Execução com Docker</h4>

```bash
# 1. Build da imagem
docker build -t qrcode-generator .

# 2. Execute o container com as variáveis de ambiente
docker run --env-file .env -p 8080:8080 qrcode-generator
```

<h4>📁 Exemplo de .env</h4>

```.env
AWS_ACCESS_KEY=SUACHAVE
AWS_SECRET_KEY=SUA_CHAVE_SECRETA
AWS_S3_BUCKET=nome-do-bucket
AWS_S3_REGION=us-east-1
```

<h4>📫 Requisição para geração</h4>

```http request
POST /qrcode
Content-Type: application/json
Host: localhost:8080

{
  "text": "https://github.com/Robson-Carvalho"
}
```
<h4>✅ Resposta</h4>

```json
{
  "url": "https://nome-do-bucket.s3.us-east-1.amazonaws.com/uuid.png"
}
```

</div> <div align="left"> 
    <h3>📁 Estrutura do Projeto</h3>
    <ul> 
        <li><code>controller</code>: expõe a API REST</li> 
        <li><code>service</code>: lógica para geração e upload do QR</li>
        <li><code>dto</code>: objetos de entrada e saída</li>
        <li><code>ports</code>: abstração de armazenamento</li> 
        <li><code>infrastructure</code>: implementação da AWS S3</li> 
    </ul> </div> <div align="left">
    <h3>🤝 Contribuindo</h3> 
        <ol> 
            <li>Faça um fork do projeto</li> 
            <li>Crie uma branch para sua feature (<code>git checkout -b feature/nova-feature</code>)</li> 
            <li>Commit suas alterações (<code>git commit -m 'feat: nova funcionalidade'</code>)</li>
            <li>Dê push na sua branch (<code>git push origin feature/nova-feature</code>)</li> 
            <li>Abra um Pull Request</li> 
        </ol> 
</div> 

<div align="left">
    <h3>🐛 Problemas?</h3> 
    <p> Se você encontrar algum problema ou tiver sugestões de melhoria, sinta-se à vontade para abrir uma 
        <a href="https://github.com/Robson-Carvalho/qrcode-generator/issues"><strong>issue</strong></a>. 
    </p> 
</div>

<div align="left">
  <h3>📜 Licença</h3>

  <p>Distribuído sob a licença MIT. Consulte o arquivo <a href="./LICENSE"><strong>LICENSE</strong></a> para mais detalhes.</p>
</div>