# gerenciador
Projeto para o plantão de Java do Perifacode 

# Objetivo da aplicação
 Permitir gerenciar informações da comunidade.

## Entendendo o Negócio

O Perifacode possui membros, sendo que existem membros que podem ser parte da organização e podem ser voluntários em iniciativas.
Os membros podem estar em várias iniciativas como participantes também.

Existem tipos diferentes de iniciativas, como plantões e eventos por exemplo.

A agenda do Perifacode possui os horários que ocorrem as iniciativas e é uma forma bem bacana dos membros entenderem o que esta rolando.

Cada Membro ao entrar no Perifacode, deve aceitar a politica da comunidade e pode se registrar usando seu e-mail que é único por membro.

Como podemos ter muitos membros com acesso adm, precisamos ter resgitro de data de inclusão e data de alteração e também log de quem realizou a ação em todos os processos de inclusão, atualização e deleção.

E como o Perifacode quer melhorar análise de suas ações, as deleções serão feitas de maneira lógica, ou seja, somente inativando o registro.

Inicialmente fomos o que levantamos para iniciar o desenvolvimento.

### Features

#### Serviço de Membros
- [x]  Quais informações um membro tem ? Inicialmente ele tem um e-mail, usuario, aceite, data de inclusão, data de alteração e interesses(lista de palavras que estão ligados ao que o membro gosta) e campo de ativo ( indicando para membros que não fazem mais parte como inativo)
- [x]  Criar membro,
- [x]  Atualizar membro,
- [x]  Excluir lógicamente o membro (inativar),
- [ ]  Pesquisar membro por id.
- [ ]  Pesquisar membros.(lista)
- [ ]  Pesquisar membro por usuário ou email.
- [ ]  Pesquisar membros por data de inclusão ou data de atualização, se ele é voluntário ou não
- [ ]  Pesquisar membros que são voluntários por iniciativa
    
#### Serviço de Tipos de Iniciativas
- [x]  O que um serviço de tipo tem de informação? código, Titulo, descrição, data de cadastro, data de atualização, ativo
- [x]  Criar cadastrado de Tipos de Iniciativas
- [ ]  Atualizar tipo de iniciativa
- [ ]  Lista de  tipos de iniciativas
- [ ]  Inativar tipo de iniciativa
- [x]  Busca de tipos de Iniciativa por código 
- [ ]  Busca de tipos de Iniciativa (lista), com filtros de data de criação, data de inativação e por status (ativo ou inativo)
    
#### Serviço de Iniciativa
- [x]  Quais campos deve ter neste serviço? Código, Titulo, data de cadastro, data de atualização, ativo, iniciativa, lista de responsáveis.
- [x]  Criar iniciativa ( ela deve ter um tipo vinculado a ela e uma lista de voluntários responsáveis, considerando que nesta lista, deve conter pelo menos 1 voluntário, isso para evitar que uma iniciativa seja criada sem um reposável inicial )
- [ ]  Atualizar iniciativa
- [ ]  Inativar iniciativa
- [ ]  Consultar iniciativa por id
- [ ]  Consultar iniciativas - Lista
- [ ]  Consultar iniciativas por data de cadastro
- [ ]  Consultar iniciativas por tipo

#### Serviço de Grade de atividades da comunidade
- [ ]  Quais campo este serviço deve possuir? Data inicio, Data fim, horário inicio, horário fim, responsavel pelo agendamento, iniciativas, membros que querem participar, lista de notas .
- [ ]  O recurso de agenda permite membros e voluntários registrarem datas de encontros ou ações de inicitaivas.
- [ ]  Na agenda será possível criar compromissos por data e horário
- [ ]  Quando a Data não for preenchida assumirá como data inicial e final a data atual.
- [ ]  O AGENDAMENTO poderá durar mais de um dia, e ter mais de uma iniciativa envolvida.
- [ ]  O agendamento deverá receber os dados do usuário que agendou o compromisso e colocá-lo como resposável
- [ ]  Será possível que os membros marquem confirmação no compromisso na iniciativa.
- [ ]  Será possível enviar e-mail de aviso para os confirmados no compromisso.
- [ ]  Será possível registrar lista de informações no compromisso.
- [ ]  Permitir consultar compromisso por iniciativa
- [ ]  Permitir consultar compromisso por período de data.
- [ ]  Permitir consultar membros confirmados em um agendamento.


## Como contribuir:

###  Acesso:
    - Caso não seja membro do Perifacode, acesse https://docs.google.com/forms/d/e/1FAIpQLSd9ptSntk4FklmD-Lb0B0C6KL2xgijym2jx1G-FQVw8IIvxYQ/viewform realize o seu cadastro e entre no Discord.
    - Solicite acesso ao repositório pelo canal #plantao-java do Discord do Perifacode marcando @Maximillian Arruda#8146 com seu usuario do Github

### Task:

    - Verifique qual Task esta em prioridade (de cima para baixo)
    - Arraste a task que irá desenvolver para a coluna in progress
    - Preencha seu nome na Task
    - Não esqueça de movê-la para In progress para sinalizar que esta em andamento.

### Branch:
    - Crie a branch a partir da develop
    - O nome da sua branch deve seguir o padrão feature + identificação da task, exemplo: feature/membro

### Fluxo:
    - Após terminar o desenvolvimento mude sua task para a coluna Code Review e abra Pull Request da sua branch para a develop
    - Após um Pull Request ser aprovado e mergeado na Develop ele deve ser Release e deve ser aberto Pull Request da Develop para a Master

### Documentação
    Toda e qualquer informação do projeto que seja importante deve estar no README ou na Wiki do projeto https://github.com/dearrudam/gerenciador/wiki

### Arquitetura
    A arquitetura do projeto segue o padrão Clean Arch, tente seguir o modelo, caso tenha dúvidas acesse https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html

### Build
    Ao realizar o build será feita análise de código pelo CheckStyle, pode ser que sejam apontados erros de Code Style, para saber o que corrigir você deve abrir o arquivo main.html e ver o erro que eve ser corrigido
    
