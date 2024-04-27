/* eslint-disable react/prop-types */
import Checkbox from '@mui/material/Checkbox';
import OutboxIcon from '@mui/icons-material/Outbox';
import CalculateIcon from '@mui/icons-material/Calculate';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import { Button, Grid, Switch, TextField } from "@mui/material";
import Typography from '@mui/material/Typography';
import { useState } from 'react';

export default function FormReparacion(props) {

    const data = props.data;
    var bonomarca = 0;
    const [tipo1, setTipo1] = useState(false);
    const [tipo2, setTipo2] = useState(false);
    const [tipo3, setTipo3] = useState(false);
    const [tipo4, setTipo4] = useState(false);
    const [tipo5, setTipo5] = useState(false);
    const [tipo6, setTipo6] = useState(false);
    const [tipo7, setTipo7] = useState(false);
    const [tipo8, setTipo8] = useState(false);
    const [tipo9, setTipo9] = useState(false);
    const [tipo10, setTipo10] = useState(false);
    const [tipo11, setTipo11] = useState(false);

    const bonos = [
        {
            id: 1,
            marca: 'TOYOTA',
            cantidad: 2,
            monto: 70000
        },
        {
            id: 2,
            marca: 'FORD',
            cantidad: 1,
            monto: 50000
        },
        {
            id: 3,
            marca: 'HYUNDAI',
            cantidad: 3,
            monto: 30000
        },
        {
            id: 4,
            marca: 'HONDA',
            cantidad: 1,
            monto: 40000
        }
    ];

    console.log(data.n_patente);

    const handleChange = (event) => {

        if (event.target.checked) {

            if (data.marca === 'TOYOTA' && bonos[0].cantidad > 0) {
                bonomarca = bonos[0].monto;
                bonos[0].cantidad = bonos[0].cantidad - 1;
            }
            if (data.marca === 'FORD' && bonos[1].cantidad > 0) {
                bonomarca = bonos[1].monto;
                bonos[1].cantidad = bonos[1].cantidad - 1;
            }
            if (data.marca === 'HYUNDAI' && bonos[2].cantidad > 0) {
                bonomarca = bonos[2].monto;
                bonos[2].cantidad = bonos[2].cantidad - 1;
            }
            if (data.marca === 'HONDA' && bonos[3].cantidad > 0) {
                bonomarca = bonos[3].monto;
                bonos[3].cantidad = bonos[3].cantidad - 1;
            }
            console.log('Aplicar bono por marca');
        }
        else {
            console.log('No aplicar bono por marca');
        }

        //console.log(event.target.checked);
    }

    const handleTipo1 = (event) => {
        setTipo1(event.target.checked);

        
        console.log('Tipo 1 uno wan');
        console.log(event.target.checked);
    }

    return (
        <>
            <Grid container spacing={2}>

                <Grid item xs={6}>
                    <h4>Fecha Ingreso</h4>
                    <TextField

                        id="fechaingreso"
                        label="Ingrese la fecha de ingreso"
                        fullWidth
                        required

                    > </TextField>
                </Grid>

                <Grid item xs={6}>
                    <h4>Tipo de Reparación</h4>
                    <FormControl component="fieldset">
                        <FormGroup aria-label="position" row>
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="1"
                                onChange={handleTipo1}
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="2"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="3"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="4"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="5"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="6"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="7"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="8"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="9"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="10"
                                labelPlacement="top" />
                            <FormControlLabel
                                value="top"
                                control={<Checkbox />}
                                label="11"
                                labelPlacement="top" />
                        </FormGroup>
                    </FormControl>

                </Grid>

                {data.marca === 'TOYOTA'|| data.marca === 'FORD' || data.marca === 'HYUNDAI' || data.marca === 'HONDA' ? <Grid item xs={6} container justifyContent="center" alignItems="center">

                    <Typography>No</Typography>
                    <FormControlLabel
                        onChange={handleChange}
                        value="top"
                        control={<Switch color="primary" />}
                        label="Aplicar Bono Por Marca"
                        labelPlacement="top"
                    />
                    <Typography>Si</Typography>
                </Grid> : null}


            </Grid>
            <Grid container spacing={2} sx={{ display: 'flex', justifyContent: 'center' }}>
                <Grid item>
                    <Button
                        startIcon={<CalculateIcon />}
                        type="submit"
                        variant="outlined"

                        sx={{ mt: 3, mb: 2, marginLeft: 0, marginTop: 6, width: '20rem' }}
                    >
                        Calcular Costo
                    </Button>
                </Grid>
                <Grid item>
                    <Button
                        startIcon={<OutboxIcon />}
                        type="submit"
                        variant="contained"

                        sx={{ mt: 3, mb: 2, marginLeft: 0, marginTop: 6, width: '20rem' }}
                    >
                        Ingresar Reparación
                    </Button>
                </Grid>
            </Grid>
        </>
    );
}
