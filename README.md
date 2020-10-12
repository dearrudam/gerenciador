# gerenciador
Projeto para o plantão de Java do Perifacode 

#Objetivo da aplicação
Permitir gerenciar informações da comunidade.

##Entendendo o Negócio

O Perifacode possui membros, sendo que existem membros que podem ser parte da organização e podem ser voluntários em iniciativas.
Os membros podem estar em várias iniciativas como participantes também.

Existem tipos diferentes de iniciativas, como plantões e eventos por exemplo.

A agenda do Perifacode possui os horários que ocorrem as iniciativas e é uma forma bem bacana dos membros entenderem o que esta rolando.

Cada Membro ao entrar no Perifacode, deve aceitar a politica da comunidade e pode se registrar usando seu e-mail que é único por membro.

Como podemos ter muitos membros com acesso adm, precisamos ter resgitro de data de inclusão e data de alteração e também log de quem realizou a ação em todos os processos de inclusão, atualização e deleção.

E como o Perifacode quer melhorar análise de suas ações, as deleções serão feitas de maneira lógica, ou seja, somente inativando o registro.

Inicialmente fomos o que levantamos para iniciar o desenvolvimento.

###Features

- Serviço de Membros
    -Quais informações um membro tem ? Inicialmente ele tem um e-mail, usuario, aceite, data de inclusão, data de alteração e interesses(lista de palavras que estão ligados ao que o membro gosta) e campo de ativo ( indicando para membros que não fazem mais parte como inativo)
    -Criar membro, 
    -Atualizar e-mail do membro, 
    -Excluir lógicamente o membro (inativar), 
    -Pesquisar membro por usuário ou email.
    -Pesquisar membro por data de inclusão.
    -Pesquisar membro por data de atualização.
    -Pesquisar membros que são voluntários.
    -Pesquisar membros que são voluntários por iniciativa
    
- Serviço de Tipos de Iniciativas
    - O que um serviço de tipo tem de informação? código, Titulo, descrição, data de cadastro, data de atualização, ativo
    -Criar cadastrado de Tipos de Iniciativas
    -Atualizar Descrição e nome do tipo de iniciativa
    -Busca de tipos de Iniciativa
    -Pesquisa iniciativa por data de criação
    -Pesquisa iniciativa por data de inativação
    
-Serviço de Iniciativa
    -Quais campos deve ter neste serviço? Código, Titulo, data de cadastro, data de atualização, ativo, iniciativa, lista de responsáveis.
    -Criar iniciativa ( ela deve ter um tipo vinculado a ela e uma lista de voluntários responsáveis, considerando que nesta lista, deve conter pelo menos 1 voluntário, isso para evitar que uma iniciativa seja criada sem um reposável inicial )
    -Atualizar iniciativa
    -Inativar iniciativa
    -Consultar iniciativas por data de cadastro
    -Consultar iniciativas por tipo    

- Serviço de Agenda
    - Quais campo este serviço deve possuir? Data inicio, Data fim, horário inicio, horário fim, responsavel pelo agendamento, iniciativas, membros que querem participar, lista de notas .
    -O recurso de agenda permite membros e voluntários registrarem datas de encontros ou ações de inicitaivas.
    -Na agenda será possível criar compromissos por data e horário 
    -Quando a Data não for preenchida assumirá como data inicial e final a data atual.
    -O AGENDAMENTO poderá durar mais de um dia, e ter mais de uma iniciativa envolvida.
    -O agendamento deverá receber os dados do usuário que agendou o compromisso e colocá-lo como resposável
    -Será possível que os membros marquem confirmação no compromisso na iniciativa.
    -Será possível enviar e-mail de aviso para os confirmados no compromisso.
    -Será possível registrar lista de informações no compromisso.
    -Permitir consultar compromisso por iniciativa 
    -Permitir consultar compromisso por período de data.
    -Permitir consultar membros confirmados em um agendamento.
    
    
## Como contribuir:

Crie a task do desafio no Kaban do Projeto, indo na aba Projects do repositório do projeto do Github:
https://github.com/psanrosa13/gerenciador/projects/1

Para sua feature siga o padrão colocando o nome do serviço,data e horario como sendo o identificador da sua feature no card e na branch consecutivamente , exemplo:
Exemplo:membro121020201557

Crie sua task em Todo , mude ela para a fase de in progress, depois que desenvolver, mude ela para a coluna de code review e abra o Pull Request da sua branch para a branch develop, depois que seu Pr for aceito, você irá criar a release para a master e então irá fazer o merge da develop para a release e depois feita a execução da branch na release então é feito o merge da release na master, quando isso for executado podemos considerar em Done;

