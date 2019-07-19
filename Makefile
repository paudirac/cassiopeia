cassiopea-latest:
	docker build -t cassiopea:latest .

run: cassiopea-latest
	docker run -it --rm --name cassiopea -p "9000:9000" -p "3449:3449" -v $(PWD):/usr/src/app cassiopea:latest

shell: cassiopea-latest
	docker run --rm -it -v $(PWD):/usr/src/app cassiopea:latest /bin/bash
