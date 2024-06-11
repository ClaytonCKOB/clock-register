import axios from 'axios';

interface ClockIntervalData {
  id: number;
  id_user: number;
  start: string;
  ending: string;
}

export default class ClockIntervalService {
    private axiosInstance;

    constructor() {
        this.axiosInstance = axios.create({
            baseURL: import.meta.env.ENDPOINT ?? 'http://localhost:8080'
        });
    }

    async list(dados: object): Promise<ClockIntervalData[]> {
        const { data } = await this.axiosInstance.get<ClockIntervalData[]>('/api/clock');
        return data;
    }

    async create(dados: object): any {
        let token = '';
        return this.axiosInstance.post('/api/clock', dados, {
            headers: { Authorization: `Bearer ${token}` }
        });
    }

    async delete(id: number): Promise<any> {
        try {
            const response = await this.axiosInstance.delete(`/api/clock/delete/${id}`);

            return response.data;
        } catch (error) {
            console.error('Error deleting the item:', error);
            throw error;
        }
    }

}
