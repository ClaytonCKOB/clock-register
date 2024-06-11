import { useEffect, useState } from 'react';
import ClockIntervalService, { ClockIntervalData } from '../../services/ClockIntervalService';

export default function Interval() {
  const [data, setData] = useState<ClockIntervalData[]>([]);
  const [newInterval, setNewInterval] = useState({
    start_date: '',
    start_time: '',
    end_date: '',
    end_time: ''
  });

  const clockIntervalService = new ClockIntervalService();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await clockIntervalService.list({});
        setData(result);
      } catch (error) {
        console.error('Error fetching clock intervals:', error);
      }
    };

    fetchData();
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewInterval(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const deleteClock = (id) => {
    clockIntervalService.delete(id);
    console.log(document.querySelector(`[key='${id}']`));
    setData(data.filter(record => record.id !== id));
  };

  useEffect(() => {
    const { start_date, start_time, end_date, end_time } = newInterval;
    if (start_date && start_time && end_date && end_time) {
      setData(prevData => [...prevData, { ...newInterval, id: Date.now(), id_user: 1 }]); 
      setNewInterval({ start_date: '', start_time: '', end_date: '', end_time: '' });
      clockIntervalService.create({ id_user: 1, start_date, start_time, end_date, end_time });

    }
  }, [newInterval]);

  const calculateTotal = (startDate, startTime, endDate, endTime) => {
    const start = new Date(`${startDate}T${startTime}`);
    const end = new Date(`${endDate}T${endTime}`);
    const diffMs = end - start;
    const diffHrs = Math.floor(diffMs / (1000 * 60 * 60));
    const diffMins = Math.floor((diffMs % (1000 * 60 * 60)) / (1000 * 60));
    return `${diffHrs}h ${diffMins}m`;
  };

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Dia da Semana</th>
            <th>Inicio</th>
            <th>Fim</th>
            <th>Total</th>
            <th>Excluir</th>
          </tr>
        </thead>
        <tbody>
          {data?.map((interval) => {
            const dias_semana = ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'];
            const startDate = new Date(interval.start_date);
            return (
              <tr key={interval.id}>
                <td>{dias_semana[startDate.getDay()]}</td>
                <td><input type="date" value={interval.start_date} readOnly /> <input type="time" value={interval.start_time?.substring(0, 5)} readOnly /></td>
                <td><input type="date" value={interval.end_date} readOnly /> <input type="time" value={interval.end_time?.substring(0, 5)} readOnly /></td>
                <td>{calculateTotal(interval.start_date, interval.start_time, interval.end_date, interval.end_time)}</td>
                <td>
                  <button onClick={() => {deleteClock(interval.id)}}>X</button>
                </td>
              </tr>
            );
          })}
          <tr>
            <td>{newInterval.start_date ? ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'][new Date(newInterval.start_date).getDay()] : ''}</td>
            <td><input type="date" name="start_date" value={newInterval.start_date} onChange={handleInputChange} /> <input type="time" name="start_time" value={newInterval.start_time} onChange={handleInputChange} /></td>
            <td><input type="date" name="end_date" value={newInterval.end_date} onChange={handleInputChange} /> <input type="time" name="end_time" value={newInterval.end_time} onChange={handleInputChange} /></td>
            <td>{newInterval.start_date && newInterval.start_time && newInterval.end_date && newInterval.end_time ? calculateTotal(newInterval.start_date, newInterval.start_time, newInterval.end_date, newInterval.end_time) : ''}</td>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}
