FROM node:alpine
WORKDIR /app
COPY package.json ./
COPY package-lock.json ./
COPY ./ ./
RUN npm cache clean --force
RUN npm install
EXPOSE 5173
CMD [ -d "node_modules" ] && npm run dev || npm run dev