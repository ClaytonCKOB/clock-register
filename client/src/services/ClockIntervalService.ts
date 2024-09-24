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
        let token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJjbG9ja3JlZ2lzdGVyIiwic3ViIjoiY2xheXRvbmthdWEiLCJleHAiOjE3MTgyNDk3MTV9.WISGHYFeD3GYktfLbvT_MntSuDL3-cbjs4a5mGYAs3g';
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
