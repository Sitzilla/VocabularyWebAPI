# VocabularyWebAPI
Spring REST Web API for Vocabulary Terms.
`vocabularyterms.herokuapp.com/<language>`

# Supported Languages
- japanese
- korean
- chinese

# Required Headers
- Conten-Type: application/json
- Authorization token (managerial endpoints)

![Alt text](/../screenshots/screenshots/headers.png?raw=true "Headers")

# Current Endpoints
- GET list 

`vocabularyterms.herokuapp.com/{language}`

![Alt text](/../screenshots/screenshots/list.png?raw=true "Headers")

- GET single
`vocabularyterms.herokuapp.com/{language}/{id}`

![Alt text](/../screenshots/screenshots/single.png?raw=true "Headers")

- GET single random
`vocabularyterms.herokuapp.com/{language}/random`

![Alt text](/../screenshots/screenshots/random.png?raw=true "Headers")

- POST create a new word
vocabularyterms.herokuapp.com/{language}`

![Alt text](/../screenshots/screenshots/create.png?raw=true "Headers")

- PUT modify a current word by id
`vocabularyterms.herokuapp.com/{language}/{id}`

- DELETE a current word by id
`vocabularyterms.herokuapp.com/{language}/{id}`

# Allowable Filters
- level
- category

![Alt text](/../screenshots/screenshots/filters.png?raw=true "Headers")

# POST/PUT Request Body Fields
- id
- foreignWord
- englishWord
- active
- level
- category
