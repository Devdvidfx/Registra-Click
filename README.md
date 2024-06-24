# Sistema de Controle de Registros de Funcionários em JavaFX

# Sumário

## 1. [Introdução](#introdução)
## 2. [Funcionalidades Principais](#funcionalidades-principais)
   - [Visualização Interativa](#visualização-interativa)
   - [Gestão de Ações](#gestão-de-ações)
   - [Relatórios Automatizados](#relatórios-automatizados)
## 3. [Tecnologias Utilizadas](#tecnologias-utilizadas)
## 4. [Estrutura do Projeto](#estrutura-do-projeto)
## 5. [Instruções para Utilização](#instruções-para-utilização)
   - [Execução](#execução)
   - [Interatividade](#interatividade)
   - [Relatórios](#relatórios)
## 6. [Conclusão](#conclusão)


# Introdução

Este projeto consiste em uma aplicação desenvolvida em JavaFX para efetuar o gerenciamento de registros de funcionários em uma empresa. A aplicação oferece uma interface intuitiva que permite visualizar e interagir com uma tabela de funcionários, onde é possível realizar a seleção de múltiplos colaboradores para ações como retirada ou devolução de patrimônio.

## Funcionalidades Principais

### Visualização Interativa

- Utilização de uma tabela dinâmica para visualizar e selecionar funcionários.

### Gestão de Ações

- Funcionalidades para realizar operações de retirada e devolução de patrimônio.
- Validação automática para garantir a seleção exclusiva de uma ação por vez.

### Relatórios Automatizados

- Geração automática de relatórios em formato Excel.
- Detalhamento das ações realizadas para cada funcionário.

## Tecnologias Utilizadas

- **JavaFX**: Utilizado para o desenvolvimento da interface gráfica robusta e responsiva.
- **Apache POI**: Biblioteca Java utilizada para manipulação de arquivos Excel, permitindo a criação e atualização dos relatórios de forma eficiente.
- **Controle de Eventos**: Implementação em Java e JavaFX para o gerenciamento de eventos de interação do usuário.

## Estrutura do Projeto

- **Application.java**: Classe principal que inicializa a aplicação JavaFX, integrando a interface definida no arquivo `view.fxml`.
- **Controller.java**: Controlador que gerencia a lógica da interface, incluindo a inicialização da tabela de funcionários e o tratamento de eventos de interação do usuário.
- **Funcionario.java**: Classe modelo que representa os dados de um funcionário, com propriedades como nome, função, matrícula e patrimônio.

## Instruções para Utilização

### Execução

- Para iniciar a aplicação, execute o método `main` na classe `Application.java`.

### Interatividade

- Selecione os funcionários desejados na tabela.
- Escolha entre as opções de retirada ou devolução de patrimônio.

### Relatórios

- O sistema automaticamente cria um arquivo Excel contendo um registro detalhado das ações realizadas.
- Facilita a gestão e o acompanhamento das operações.

# Tutorial: Sistema de Controle de Registros de Funcionários em JavaFX

Neste tutorial, vamos explorar passo a passo como utilizar e entender o Sistema de Controle de Registros de Funcionários desenvolvido em JavaFX. Este sistema permite gerenciar os registros de funcionários de uma empresa, com funcionalidades para visualização, seleção, e ações de retirada ou devolução de patrimônio.

## Funcionalidades do Sistema

### Visualização Interativa de Funcionários

- Ao iniciar o sistema, você verá uma tabela contendo os funcionários cadastrados. Cada linha representa um funcionário e suas respectivas informações como nome, função, matrícula e patrimônio.

### Seleção de Funcionários

- Você pode selecionar os funcionários na tabela clicando na célula da primeira coluna, que contém checkboxes. Essa seleção é essencial para realizar as operações de retirada ou devolução de patrimônio.

### Ações de Retirada e Devolução

- Após selecionar os funcionários desejados, você tem a opção de realizar ações de retirada ou devolução de patrimônio.
- Para selecionar uma ação, marque apenas uma das opções disponíveis: "Retirar" ou "Devolver".
- O sistema garante que apenas uma dessas ações possa ser selecionada por vez, evitando ambiguidades.

### Geração de Relatórios em Excel

- Após confirmar as ações de retirada ou devolução, o sistema gera automaticamente um relatório em formato Excel.
- Esse relatório contém detalhes das operações realizadas, como a data, nome do funcionário, função, patrimônio e ação realizada (retirada ou devolução).

## Tecnologias Utilizadas

- **JavaFX**: Framework utilizado para o desenvolvimento da interface gráfica.
- **Apache POI**: Biblioteca Java utilizada para manipulação de arquivos Excel, permitindo a criação e edição de planilhas de forma programática.
- **Java e JavaFX**: Utilizados para a lógica de controle de eventos, validações e interações com o usuário.

## Passo a Passo para Utilização

### Pré-requisitos

- Certifique-se de ter o Java instalado na sua máquina.

### Execução do Sistema

1. Abra o projeto na sua IDE Java.
2. Localize e execute o método `main` na classe `Application.java`.

### Interagindo com a Interface

- Na interface do sistema, você verá a tabela de funcionários.
- Clique nas checkboxes da primeira coluna para selecionar os funcionários desejados.

### Realizando Ações

1. Escolha entre "Retirar" ou "Devolver" o patrimônio dos funcionários selecionados.
2. Caso tente selecionar ambas as opções ao mesmo tempo, o sistema exibirá um alerta para escolher apenas uma.

### Visualizando Relatórios

- Após confirmar a ação, um arquivo Excel será automaticamente gerado e salvo localmente.
- Este arquivo conterá um registro detalhado de todas as operações realizadas.

## Conclusão

Este tutorial abordou como utilizar o Sistema de Controle de Registros de Funcionários em JavaFX, destacando suas funcionalidades principais, tecnologias utilizadas e passos necessários para sua utilização. A aplicação oferece uma solução eficiente para o gerenciamento de patrimônio de funcionários, facilitando a organização e registro das operações realizadas.
