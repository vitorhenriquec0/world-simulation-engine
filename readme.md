# > World Simulation Engine

## Sobre o projeto

O **World Simulation Engine** é um projeto desenvolvido em **Java** com o objetivo de estudar e aplicar conceitos de **Programação Orientada a Objetos**, modelagem de domínio e regras de negócio em um sistema complexo e evolutivo.

O projeto simula um mundo composto por uma cidade e sua população, onde pessoas nascem, trabalham, envelhecem, morrem e reagem às condições econômicas e sociais ao longo do tempo.  
A simulação é baseada em regras mensais e anuais, permitindo observar o comportamento do sistema conforme os anos avançam.

Este projeto foi desenvolvido exclusivamente para **aprendizado**, acompanhando meus estudos em Java backend.

---

## Como funciona a simulação

- O tempo avança em **meses e anos**
- A cada mês e ano, um conjunto de **regras independentes** é aplicado ao mundo
- O estado do mundo evolui de forma automática, sem intervenção do usuário
- Eventos aleatórios podem alterar drasticamente o comportamento da cidade

---

## Principais conceitos simulados

### População
- Cidadãos possuem:
  - idade
  - profissão
  - saldo financeiro
  - nível de felicidade
  - relações familiares (pais e filhos)
- Nascimentos ocorrem com base em regras demográficas
- Envelhecimento e mortalidade são simulados anualmente

### Trabalho e economia
- Profissões com salários diferentes
- Tributação automática sobre salários e bônus
- Tesouro público que financia infraestrutura
- Incentivos econômicos (ex: comércio em mercados)

### Estado e políticas
- Construção automática de prédios públicos quando há recursos
- Infraestruturas impactam diretamente:
  - desemprego
  - mortalidade
  - felicidade
- Rebeliões podem ocorrer caso a felicidade média caia demais

### Herança
- Quando um cidadão morre:
  - seu dinheiro é **dividido entre os filhos**, com cobrança de imposto
  - se não houver filhos, o valor é transferido integralmente para o Estado

### Eventos aleatórios
- Epidemias
- Booms econômicos
- Crises sociais

---

## Arquitetura

O projeto foi estruturado para facilitar extensões e experimentação:

- **SimulationEngine**  
  Responsável por executar regras mensais e anuais

- **SimulationRule (interface)**  
  Cada regra do sistema é isolada em sua própria classe

- **Modelagem de domínio clara**  
  (`World`, `City`, `Citizen`, `Economy`, `BuildingType`, etc.)

- **Configuração centralizada**  
  Parâmetros globais controlados via `SimulationConfig`

Essa abordagem permite adicionar, remover ou alterar regras sem impactar o restante do sistema.

---

## Tecnologias e conceitos utilizados

- Java
- Programação Orientada a Objetos
- Interfaces
- Enums com comportamento
- Encapsulamento
- Separação de responsabilidades
- Collections e Streams
- Simulação baseada em regras
- Modelagem de domínio

---

Possíveis extensões futuras (não implementadas):
- múltiplas cidades com políticas diferentes
- comparação de cenários
- persistência de dados
- interface gráfica
- permitir a interação do usuário

---

## ▶Execução

O projeto roda diretamente pelo método `main`, sem dependências externas:

```bash
javac Main.java
java Main
