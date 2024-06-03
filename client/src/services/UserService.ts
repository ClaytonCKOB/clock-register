import axios from 'axios';

export default class UserService {
    private axios;

    constructor () {
        this.axios = axios.create({
            baseURL: process.env.ENDPOINT
        });
    }

    async login (dados:object) {
        const {data} = await this.axios.post('/login', dados);

        if (data) {
            localStorage.setItem('token', data.data.token);

            return true;
        }

        return false;
    }
}