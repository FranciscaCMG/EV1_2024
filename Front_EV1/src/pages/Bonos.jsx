export default function Bonos() {

    const [bonosToyota, setBonosToyota] = useState(70000);
    const [bonosFord, setBonosFord] = useState(50000);
    const [bonosHyundai, setBonosHyundai] = useState(30000);
    const [bonosHonda, setBonosHonda] = useState(40000);
    const columns = [
        { field: 'id', headerName: 'ID', width: 90 },
        {
          field: 'marca',
          headerName: 'Marca',
          width: 150,
          editable: true,
        },
        {
          field: 'cantidad',
          headerName: 'cantidad',
          width: 150,
          editable: true,
        },
        {
          field: 'monto',
          headerName: 'monto',
          width: 150,
          editable: true,
        },
        
      ];

      const rows = [
        { id: 1, marca: 'Toyota', cantidad: '5', monto: 70000 },
        { id: 2, marca: 'Ford', cantidad: '2', monto: 50000 },
        { id: 3, marca: 'Hyundai', cantidad: '1', monto: 30000 },
        { id: 4, marca: 'Honda', cantidad: '7', monto: 40000 },    
      ];

    return (
        <div>
            <h1 style={{ textAlign: 'center' }}>Bonos</h1>
        </div>




    );
}