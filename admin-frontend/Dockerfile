FROM node:alpine AS builder

WORKDIR /app

#COPY package.json package-lock.json ./
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/* && rm -rf /etc/nginx/nginx.conf
COPY ./nginx.conf /etc/nginx/nginx.conf
#COPY --from=node /dist/admin-frontend /usr/share/nginx/html
COPY /dist/admin-frontend /usr/share/nginx/html

# STEP 2 build a small nginx image with static website
#FROM nginx:alpine
#COPY ./nginx.conf /etc/nginx/nginx.conf
#RUN rm -rf /usr/share/nginx/html/*
#COPY --from=builder /dist /usr/share/nginx/html
#RUN ls /usr/share/nginx/html
#EXPOSE 80
#CMD ["nginx", "-g", "daemon off;"]
#CMD["npm", "start"]
