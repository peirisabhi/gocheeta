#FROM node:16.16.0-alpine AS build
#WORKDIR /usr/src/app
#COPY package.json package-lock.json ./
#RUN npm install
#COPY . .
#RUN npm run build

FROM nginx:1.17.1-alpine
COPY /dist/frontend /usr/share/nginx/html
