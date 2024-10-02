# Execução

- O projeto usa gradle e a versão 21 do jdk.
- Para rodar o projeto basta executar `./gradlew run --console-plain`, ou `gradlew.bat run --console-plain` caso esteja no windows, no terminal de sua escolha (o argumento `--console-plain` serve para remover a barra de progresso que o gradle renderiza no terminal, que atrapalha a interação com o aplicativo).
  - É recomendado uso de um terminal com fonte monospace para melhor visualização da fila

# Uso

O projeto usa uma éspecie de "REPL" (Read-Evaluate-Print-Loop), onde um menu com todas as funcionalidades disponíveis está sempre presente na tela. Menus podem conter submenus, que liberam funcionalidades novas.

Exemplo de uma sessão:

```
❯ ./gradlew --console=plain run
> Task :app:compileJava UP-TO-DATE
> Task :app:processResources NO-SOURCE
> Task :app:classes UP-TO-DATE

> Task :app:run

Escolha uma função:
> 1 - Adicionar novo elemento
> 2 - Visualizar fila
> 3 - Sair

> 1
Descreva o novo elemento da árvore (digite "voltar" para voltar):
Caractere: $
Em morse: ----
Elemento inserido com sucesso!

Escolha uma função:
> 1 - Adicionar novo elemento
> 2 - Visualizar fila
> 3 - Sair

> 2
├── ✕
│   ├── E
│   │   ├── I
│   │   │   ├── S
│   │   │   │   ├── H
│   │   │   │   │   ├── 5
│   │   │   │   │   └── 4
│   │   │   │   └── V
│   │   │   │       └── 3
│   │   │   └── U
│   │   │       ├── F
│   │   │       └── ✕
│   │   │           └── 2
│   │   └── A
│   │       ├── R
│   │       │   ├── L
│   │       └── W
│   │           ├── P
│   │           └── J
│   │               └── 1
│   └── T
│       ├── N
│       │   ├── D
│       │   │   ├── B
│       │   │   │   ├── 6
│       │   │   └── X
│       │   └── K
│       │       ├── C
│       │       └── Y
│       └── M
│           ├── G
│           │   ├── Z
│           │   │   ├── 7
│           │   └── Q
│           └── O
│               ├── ✕
│               │   ├── 8
│               └── $
│                   ├── 9
│                   └── 0

Escolha uma função:
> 1 - Adicionar novo elemento
> 2 - Visualizar fila
> 3 - Sair

> 3

BUILD SUCCESSFUL in 10s
2 actionable tasks: 1 executed, 1 up-to-date
```

# Estrutura

- Na pasta `app/src/main/java/org/puc/` estão localizados todos os arquivos de código relevantes.
- A função main se encontra no arquivo `App.java`, dentro do diretório mencionado acima.
