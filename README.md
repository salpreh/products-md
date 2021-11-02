# Products-md
Products API test with SpringBoot

## Starting project
**TLDR:** Run `./bin/build-and-run.sh` (needs docker installation)

The project has a `docker-compose` with the app container and a postgres, if you have docker and docker compose in your machine you could run the script in the path `./bin/build-and-run.sh` (you might need to give execution permissions). The script will build the project and start needed containers using `docker-compose up --build -d`.
Alternatively you could build the project using local maven installation (or with an add-hoc container) and run `docker-compose up` manually.

## Project overview
The project exposes a simple product REST API, you can expect the basic crud operations in `/product` path:
- `[POST] /product`
- `[GET] /product`
- `[GET] /product/{id}`
- `[PUT] /product/{id}`
- `[DELETE] /product/{id}`

Here is an example of the product model:
```json
{
  "title": "Valencian rice",
  "description": "Original valencian rice",
  "createdAt": "2021-11-01T00:00:00Z",
  "imageUrl": "http://mydomain/img_rice.jpg",
	"copyright": {
		"clause": "Some long text about trademark",
		"dueDate": "2024-11-01T00:00:00Z"
	}
}
```

### Structure
Inside each package of the project you can find:

- `com.salpreh.productsmd.config`: Beans and app configuration.
- `com.salpreh.productsmd.controllers`: Rest controllers.
- `com.salpreh.productsmd.dtos`: Data transfer objects exposed through controllers api.
- `com.salpreh.productsmd.entities`: DB entities.
- `com.salpreh.productsmd.repositories`: BD access repositories beans
- `com.salpreh.productsmd.services`: Business logic beans.

### Openapi doc
Openapi doc is generated and exposed in path `/v3/api-docs.yaml` using [springdoc-openapi-webmvc-core](https://github.com/springdoc/springdoc-openapi) dependency.