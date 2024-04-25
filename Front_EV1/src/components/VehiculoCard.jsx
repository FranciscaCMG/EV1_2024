import Box from '@mui/material/Box';
import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react";
import axios from 'axios';
import { Button } from '@mui/material';


const columns = [
  { field: 'id', headerName: 'ID', width: 90 },
  {
    field: 'n_patente',
    headerName: 'Patente',
    width: 130,
    editable: false,
  },
  {
    field: 'marca',
    headerName: 'Marca',
    width: 130,
    editable: false,
  },
  {
    field: 'modelo',
    headerName: 'Modelo',
    width: 130,
    editable: false,
  },
  {
    field: 'tipo_auto',
    headerName: 'Tipo',
    editable: false,
    width: 130,

  },
  {
    field: 'anio_fabricacion',
    headerName: 'Año',
    editable: false,
    width: 130,

  },
  {
    field: 'tipo_motor',
    headerName: 'Motor',
    editable: false,
    width: 130,

  },
  {
    field: 'n_asientos',
    headerName: 'Asientos',
    editable: false,
    width: 120,

  },
  {
    field: 'delete',
    headerName: 'Delete',
    sortable: false,
    width: 110,
    disableClickEventBubbling: true,
    renderCell: () => (
      <div>
        <Button
          variant='contained'
          color="error"
          
        >Eliminar</Button>
      </div>
    ),
  },

];

export default function VehiculoCard() {

  const [data, setData] = useState(null);


  const handleSubmit = (e) => {
    console.log('Hay que eliminar vehiculo');
  }

  useEffect(() => {
    axios.get('http://localhost:8090/vehiculo/listar')
      .then(response => {
        const newData = response.data.map((item, index) => ({
          ...item,
          id: index, // Añade una propiedad `id` a cada fila
        }));
        setData(newData);
      })
      .catch(error => {
        alert("No entró a la base de datos");
      });
  }, []);



  return (
    <Box sx={{ height: 371, width: '100%' }}>
      {data ? (
        <DataGrid
          rows={data}
          onCellClick={handleSubmit}
          columns={columns}
          
          initialState={{
            pagination: {
              paginationModel: {
                pageSize: 5,
              },
            },
          }}
          pageSizeOptions={[5]}
           
        />
        
      ) : (
        <div>Loading...</div>
      )}
    </Box>

  );
}