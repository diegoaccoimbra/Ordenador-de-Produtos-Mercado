# 📦 Sistema de Ordenação de Produtos para Empresa Atacadista
Este projeto foi desenvolvido como solução para um sistema de gerenciamento e ordenação de produtos de uma empresa atacadista. O programa lê um arquivo de entrada com dados de produtos, armazena-os em uma estrutura de vetor e permite ordená-los por diferentes critérios, cada um utilizando um algoritmo de ordenação específico.

---

## 🧾 Funcionalidades
- Leitura de dados a partir de um arquivo produtos.txt
- Armazenamento dos dados em um vetor
- Suporte à ordenação dos produtos por:
  - Nome (ShellSort modificado)
  - Preço (QuickSort modificado)
  - Data de validade (HeapSort iterativo)
  - Nome (via lista encadeada) (Insertion Sort)

---

## 🧱 Estrutura de Dados
Cada produto é armazenado com as seguintes informações:
- Nome do produto
- Fabricante
- Preço
- Data de validade (formato: ddMMyyyy)
- Tipo (alimentício, limpeza, etc.)

---

## 📤 Arquivo de Entrada
O arquivo produtos.txt deve estar no seguinte formato:

NOME PRODUTO # FABRICANTE # PREÇO # DATA DE VALIDADE # TIPO

### 📌 Exemplo:
- BISCOITO NEGRESCO # NESTLE # 2.08 # 20122016 # BISCOITOS
- RECHEADINHO CHOCOLATE # BAUDUCO # 2.99 # 10012017 # BISCOITOS
- AÇUCAR REFINADO # UNIÃO # 3.68 # 12122016 # CEREAIS
- PIPOCA PREMIUM # YOKI # 2.79 # 03042017 # CEREAIS

---

## 🔀 Métodos de Ordenação

1. **Ordenação por Nome do Produto**  
   - Algoritmo: ShellSort Modificado  
   - Sublistas com `h > 1` são ordenadas com Selection Sort  
   - Sublistas com `h = 1` usam Insert Sort

2. **Ordenação por Preço**  
   - Algoritmo: QuickSort Modificado  
   - Particionamento com único cursor  
   - Pivô definido pela média de três valores

3. **Ordenação por Data de Validade**  
   - Algoritmo: HeapSort Modificado (iterativo, baseado no Cormen)

4. **Ordenação por Nome (via Lista Encadeada)**  
   - Algoritmo: Insertion Sort  
   - Os dados são transferidos para uma lista encadeada após a ordenação

---

## 📁 Saída Esperada
O programa exibe os dados ordenados no seguinte formato:
NOME PRODUTO, FABRICANTE, PREÇO, VALIDADE
