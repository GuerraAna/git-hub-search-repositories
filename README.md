# git-hub-search-repositories

App Android de **busca de repositórios/usuários do GitHub** consumindo a API pública do GitHub.

## Objetivo

Praticar consumo de API REST com arquitetura MVVM: busca, listagem de resultados e exibição de detalhes/imagens.

## Tecnologias

- Kotlin + Coroutines
- **Retrofit 2** + Gson (GitHub REST API)
- **Picasso** (carregamento de avatares)
- MVVM (`lifecycle-viewmodel-ktx`, LiveData)
- AppCompat, Material, ConstraintLayout
- Gradle 8.0 / compileSdk 33 (minSdk 21)

## Pré-requisitos

- **JDK 17**
- Android SDK Platform **33**

## Como rodar

```bash
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties   # macOS
./gradlew assembleDebug
```

A tela inicial é a `GitHubSearchActivity`. A API pública do GitHub não exige chave para buscas básicas (rate limit por IP).
