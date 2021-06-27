# Работа с гитом:

качаем и устанавливаем git https://git-scm.com/

Получение репозитория и подготовка локального к работе
- Создаём папку в которой будем работать
- Открываем её в терминале, который вам нравится (VScode, PyCharm, командная строка windows)
- Настраиваем пользователя - если раньше этого ни разу не далали 
- git config --global user.name "Name" - добавление имени
- git config --global user.email name@example.com - добавление почты
- Клонируем репозиторий
- git clone https://github.com/NekazistyeProgrammisty/Bydlocodery.git
- Переходим в каталог склонированного репозитория
- Создаем ветку, в которой будете работать
- git checkout -b имя_ветки
- Создаем папку своего проекта, в папке репозитория
- Открываем в любимом редакторе папку проекта и пилим лучший в мире код

Сохраняем, что накодили
- Добавляем изменения
- git add -A
- Создаем commit
- git commit -am"Краткая характиристика, что было сделано"
- Пушим на репозиторий
- git push origin имя_ветки

Если закончили работу над своей задачей и всё работает, кидаем pull request
- Заходим в github в pull requests и кидаем реквест на ветку main (пока что)
- Ждем подтверждения

# Команды гита

git config --global user.name "Name" - добавление имени

git config --global user.email name@example.com - добавление почты

git init - инициализация локального репозитория в текущей папке

git status - смотрим как дела у нашего репозитория

git add file_name - добавление изменений с файлом file_name

git add -A - добавлений всех изменений

git commit -am"ваше сообщение" - собираем все изменения в коммит

git log - журнал коммитов

git push - отправка коммита на текущую ветку

git pull - получение изменений с текущей ветки

git remote add origin your_git_link - связь вашего репозитория с удаленным по ссылке 

git checkout -b branch_name - создание ветки branch_name

git checkout branch_name - переключение на ветку branch_name

git pull origin other_branch - получение изменений с ветки otherbranch

git push origin other_branch - отправка изменений на ветку otherbranch

git branch - список веток

git branch -D branch_name - удаление ветки branch_name

git stash - откат всех неиндексированных изменений (помещаются в отдельное хранилище)

git reset --hard commit_name - откат к коммиту commit_name
