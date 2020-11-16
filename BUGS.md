# No código
[Melhoria] - Campos "ddd" e "número" de telefone não validam o tamanho mínimo, apenas o máximo, e permitem inserir qualquer tipo de caracter.

# Na instrução
Está descrito na instrução que o endpoint da operação GET é localhost:8080/{ddd}/{numero}. 
Confirmei na classe PessoaResource a rota que estava faltando:
```
@RequestMapping("/pessoas")
```

Outra obs.:

Precisei adicionar a lib jaxb-api 2.3.0 para que o projeto executasse localmente.
