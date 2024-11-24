# Gerenciador de Pedidos de Cafeteria

Este projeto é uma aplicação Java que simula o gerenciamento de pedidos de uma cafeteria. Ele implementa uma fila de prioridade personalizada para organizar os pedidos, priorizando clientes VIP, removendo pedidos cancelados e permitindo a visualização dos pedidos pendentes sem removê-los.

---

## 🛠️ Funcionalidades

1. **Adicionar pedidos**:
    - Adicione novos pedidos à fila.
    - Diferencie clientes VIP (com maior prioridade) de clientes regulares.

2. **Processar o próximo pedido**:
    - Retire o pedido com maior prioridade (menor valor numérico) da fila e exiba os detalhes.

3. **Visualizar pedidos na fila**:
    - Liste todos os pedidos pendentes sem removê-los do sistema.

4. **Atualizar prioridade**:
    - Altere a prioridade de um pedido existente (ex.: torne-o VIP ou regular).

5. **Remover pedido cancelado**:
    - Remova um pedido da fila com base no ID.

---

## 🔧 Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do projeto.
- **Estruturas de Dados**: Implementação manual de uma *min-heap* para gerenciar a fila de prioridade.
- **Paradigma Orientado a Objetos**: Organização do código em classes e métodos para maior clareza e manutenção.

---

## 🚀 Como Executar o Projeto

1. **Pré-requisitos**:
    - Instale o [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (versão 8 ou superior).
    - Um editor ou IDE para Java, como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [Eclipse](https://www.eclipse.org/).

2. **Passos para executar**:
    - Clone ou faça o download do repositório.
    - Abra o projeto na sua IDE preferida.
    - Compile os arquivos `.java`.
    - Execute a classe `Main` para testar as funcionalidades.

---

## 📂 Estrutura do Projeto

```plaintext
src/
├── Main.java             # Classe principal para executar o sistema
├── Order.java            # Representa um pedido individual
├── Heap.java             # Implementa a estrutura de dados heap
└── OrderManagement.java  # Gerencia as regras de negócio
