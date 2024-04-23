import { Box, Button, Grid, MenuItem, TextField } from "@mui/material";
import axios from "axios";
import { useState } from "react";


const tipo = [
    {
        value: 'Todos los tipos',
        label: 'Todos los tipos',
    },
    {
        value: 'Sedan',
        label: 'Sedan',
    },
    {
        value: 'Hatchback',
        label: 'Hatchback',
    },
    {
        value: 'SUV',
        label: 'SUV',
    },
    {
        value: 'Pickup',
        label: 'Pickup',

    },
    {
        value: 'Furgoneta',
        label: 'Furgoneta',
    },
];


const motor = [
    {
        value: 'Todos los tipos',
        label: 'Todos los tipos',
    },
    {
        value: 'Gasolina',
        label: 'Gasolina',
    },
    {
        value: 'Diesel',
        label: 'Diésel',
    },
    {
        value: 'Hibrido',
        label: 'Híbrido',
    },
    {
        value: 'Electrico',
        label: 'Eléctrico',

    },
];

export default function Registro() {

    const [patente, setPatente] = useState("");
    const [marca, setMarca] = useState("");
    const [modelo, setModelo] = useState("");
    const [tipoVehiculo, setTipoVehiculo] = useState("");
    const [anio, setAnio] = useState("");
    const [motorVehiculo, setMotorVehiculo] = useState("");
    const [asientos, setAsientos] = useState("");

    const [error, setError] = useState(
        {
            errorPatente: false,
            errorMarca: false,
            errorModelo: false,
            errorTipoVehiculo: false,
            errorAnio: false,
            errorMotorVehiculo: false,
            errorAsientos: false,
            message: 'Este campo es requerido',

        }
    );
    const [helperText, setHelperText] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!patente || !marca || !modelo || !tipoVehiculo || !anio || !motorVehiculo || !asientos) {
            setError({
                ...error,
                errorPatente: !patente,
                errorMarca: !marca,
                errorModelo: !modelo,
                errorTipoVehiculo: !tipoVehiculo,
                errorAnio: !anio,
                errorMotorVehiculo: !motorVehiculo,
                errorAsientos: !asientos,
            });
            setHelperText('Este campo es requerido');
        } else {
            setError({
                errorPatente: false,
                errorMarca: false,
                errorModelo: false,
                errorTipoVehiculo: false,
                errorAnio: false,
                errorMotorVehiculo: false,
                errorAsientos: false,
                message: 'Este campo es requerido',
            });
            axios.
                post('http://localhost:8090/vehiculo/guardar', {
                    n_patente: patente,
                    marca: marca,
                    modelo: modelo,
                    tipo_auto: tipoVehiculo,
                    anio_fabricacion: anio,
                    tipo_motor: motorVehiculo,
                    n_asientos: asientos
                })
                .then(response => {
                    console.log(response);
                })
            console.log(patente, marca, modelo, tipoVehiculo, anio, motorVehiculo, asientos);
            
        }
        
    }

    return (
        <>

            <h1 style={{ textAlign: 'center' }}>Registro de Vehículos</h1>


            <Box
                component="form"
                onSubmit={handleSubmit}
                sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
            >
                <Grid container spacing={2}>

                    <Grid item xs={6}>
                        <h4>Patente</h4>
                        <TextField
                            
                            id="patente"
                            label="Ingrese la patente del vehículo"
                            fullWidth
                            error={error.errorPatente}
                            helperText={error.errorPatente ? helperText : ''}
                            required
                            value={patente}
                            onChange={(e) => setPatente(e.target.value)}

                        > </TextField>
                    </Grid>
                    <Grid item xs={6}>

                        <h4>Marca</h4>
                        <TextField

                            id="marca"
                            label="Ingrese la marca del vehículo"
                            fullWidth
                            error={error.errorMarca}
                            helperText={error.errorMarca ? helperText : ''}
                            required
                            value={marca}
                            onChange={(e) => setMarca(e.target.value)}
                        >
                        </TextField>
                    </Grid>
                    <Grid item xs={6}>
                        <h4>Modelo</h4>
                        <TextField
                            id="modelo"
                            label="Ingrese el modelo del vehículo"
                            fullWidth
                            error={error.errorModelo}
                            helperText={error.errorModelo ? helperText : ''}
                            required
                            value={modelo}
                            onChange={(e) => setModelo(e.target.value)}

                        > </TextField>
                    </Grid>
                    <Grid item xs={6}>

                        <h4>Tipo</h4>
                        <TextField

                            id="tipo"
                            select
                            label="Ingrese el tipo del vehículo"
                            fullWidth
                            error={error.errorTipoVehiculo}
                            defaultValue="Todos los tipos"
                            helperText={error.errorTipoVehiculo ? helperText : ''}
                            required
                            value={tipoVehiculo}
                            onChange={(e) => setTipoVehiculo(e.target.value)}
                        >
                            {tipo.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                    {option.label}
                                </MenuItem>
                            ))}
                        </TextField>
                    </Grid>
                    <Grid item xs={6}>
                        <h4>Año Fabricación</h4>
                        <TextField
                            id="anio"
                            label="Ingrese el año de fabricación del vehículo"
                            fullWidth
                            error={error.errorAnio}
                            helperText={error.errorAnio ? helperText : ''}
                            required
                            value={anio}
                            onChange={(e) => setAnio(e.target.value)}

                        > </TextField>
                    </Grid>
                    <Grid item xs={6}>

                        <h4>Motor</h4>
                        <TextField

                            id="motor"
                            select
                            label="Ingrese el motor del vehículo"
                            fullWidth
                            error={error.errorMotorVehiculo}
                            defaultValue="Todos los tipos"
                            helperText={error.errorMotorVehiculo ? helperText : ''}
                            required
                            value={motorVehiculo}
                            onChange={(e) => setMotorVehiculo(e.target.value)}
                        >
                            {motor.map((option) => (
                                <MenuItem key={option.value} value={option.value}>
                                    {option.label}
                                </MenuItem>
                            ))}
                        </TextField>
                    </Grid>
                    <Grid item xs={6}>
                        <h4>Número Asientos</h4>
                        <TextField
                            id="asientos"
                            label="Ingrese el número de asientos del vehículo"
                            fullWidth
                            error={error.errorAsientos}
                            helperText={error.errorAsientos ? helperText : ''}
                            required
                            value={asientos}
                            onChange={(e) => setAsientos(e.target.value)}

                        > </TextField>
                    </Grid>

                </Grid>
                <Button
                    type="submit"
                    variant="contained"
                    sx={{ mt: 3, mb: 2 }}
                >Ingresar Vehículo</Button>
            </Box>
        </>
    );
}