# Desenvolvimento de um microserviço utilizando springboot e arquitetura hexagonal.
**_Professor:_ Iratuã Júnior**


## O que iremos desenvolver nesse tutorial?


### O que é arquitetura de software?

### O que é uma arquitetura hexagonal?

**TODO:** inserir uma imagem da arquitetura exagonal, explicar cada camada. Levantar uma contextualização histórica sobre as motivações.

#### Histórico

#### Prós e contras


_____


### Recursos utilizados
Iremos utilizar uma api externa, que exibe os dados de vários planetas.
Essa API será consumida via integração, ou seja, iremos consultar um serviço externo e iremos utilizar os dados para algum propósito dentro da nossa solução.
- [API de planetas](https://docapi.dev/books/api-do-sistema-solar)

Abaixo, um exemplo de como consumir o serviço acima, disponibilizado pelo próprio desenvolvedor da API.
```java
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

// ... (imports omitidos para brevidade)

public class ExemploHttpPost {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://docapi.dev/books/api-do-sistema-solar");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Configurar método da requisição para POST
        connection.setRequestMethod("POST");
        // Configurar cabeçalho para indicar que você está enviando JSON
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        // Habilitar envio de dados no corpo da requisição
        connection.setDoOutput(true);

        // Criar objeto JSON para enviar no corpo da requisição
        String jsonInputString = "{\"chave1\": \"valor1\", \"chave2\": \"valor2\"}";

        // Obter o OutputStream da conexão para escrever os dados
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Ler a resposta da requisição
        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            System.out.println(root.path("fact").asText());
        } finally {
            // Certifique-se de fechar a conexão quando não precisar mais
            connection.disconnect();
        }
    }
}

```

Exempo de resposta no caso de sucesso:
````json
{
    "status": "OK",
    "statusMotivo": "Dados listado com sucesso na resposta.",
    "resposta": [
        {
            "imgUrl": "http://sistemasolar.docapi.dev/images/mars.png",
            "_id": "63559dabbe0ea97c2d99eae3",
            "slug": "marte-1670",
            "nome": "Marte",
            "descrição": "Marte é o quarto planeta a partir do Sol, o segundo menor do Sistema Solar. Batizado em homenagem ao deus romano da guerra, muitas vezes é descrito como o Planeta Vermelho, porque o óxido de ferro predominante em sua superfície lhe dá uma aparência avermelhada.",
            "img": "mars.png",
            "createdAt": "2022-10-23T20:01:47.745Z",
            "updatedAt": "2022-10-23T20:01:47.745Z",
        },
        {
            "imgUrl": "http://sistemasolar.docapi.dev/images/earth.png",
            "_id": "6355b203074369066225044c",
            "slug": "terra-2935",
            "nome": "Terra",
            "descrição": "A Terra é o terceiro planeta mais próximo do Sol, o mais denso e o quinto maior dos oito planetas do Sistema Solar. É também o maior dos quatro planetas telúricos. É por vezes designada como Mundo ou Planeta Azul.",
            "img": "earth.png",
            "createdAt": "2022-10-23T21:28:35.616Z",
            "updatedAt": "2022-10-23T21:28:35.616Z",
        }
    ]
}
````

Note que na implementação utilizamos um cliente http. 

