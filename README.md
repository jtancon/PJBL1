# PJBL1
Flood Fill em Java (Pilha e Fila)
=================================

Este projeto implementa o algoritmo de Flood Fill (preenchimento de áreas) utilizando estruturas próprias de Pilha e Fila, sem uso de ArrayList ou bibliotecas externas de estrutura de dados. Além disso, o projeto gera uma animação .gif que mostra o preenchimento sendo realizado passo a passo.

Objetivo
--------
Comparar o comportamento do Flood Fill utilizando:
- Pilha (DFS) – Depth-First Search (Busca em profundidade)
- Fila (BFS) – Breadth-First Search (Busca em largura)

E observar como cada estratégia preenche o espaço de forma diferente.

Como executar
-------------
1. Compile o projeto com um compilador Java (JDK 11+ recomendado).
2. Execute a classe Main.java.
3. Os resultados serão salvos em:
   - img/saida_pilha.png
   - img/saida_fila.png
   - img/animacao_pilha.gif
   - img/animacao_fila.gif

Como funciona
-------------
Estruturas utilizadas:

- MinhaPilha:
  - Implementada com nós encadeados (Node)
  - Comportamento LIFO (último a entrar, primeiro a sair)

- MinhaFila:
  - Implementada com nós encadeados (Node)
  - Comportamento FIFO (primeiro a entrar, primeiro a sair)

Conteúdo acadêmico
------------------
Este projeto foi desenvolvido com base nas exigências de estrutura de dados da disciplina Listas Lineares, com as seguintes restrições:
- Proibido uso de ArrayList, LinkedList ou bibliotecas externas.
- Uso obrigatório de estruturas encadeadas próprias (Pilha e Fila).

Professora responsável
-----------------------
Prof.ª Marina (PBL Listas Lineares)
Projeto prático sobre Pilha, Fila e Animações com Flood Fill.

Tecnologias
-----------
- Java 11+
- Manipulação de imagens com BufferedImage e ImageIO
- Geração de GIF com ImageWriter e metadados IIOMetadata

Autor
-----
Desenvolvido por João Victor Monteiro Tancon e Eric Binek Sant'Anna como parte do Projeto Baseado em Problemas (PBL) em Estruturas de Dados.
