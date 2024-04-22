import { Paper, Typography, Button } from '@mui/material';
import styled from '@emotion/styled';
import { Box } from '@mui/system';
import Grid from '@mui/material/Grid';
import VerifiedIcon from '@mui/icons-material/Verified';



export default function VehiculoCard() {

    const Img = styled("img")({
        width: 200,
        height: "100%",
        objectFit: "cover",
        objectPosition: "center",
    }

    )



    return <Paper
        sx={{
            display: "flex",
            alignItems: "center",
            gap: 2,
            overflow: "hidden",
            mt: 5,
        }}
    >

        <Img
            src="https://images.emojiterra.com/mozilla/512px/1f697.png"
            alt="Vehiculo Rojo"
        />
        <Box sx={{ flexGrow: 1, display: "grid", gap: 1 }}>
            <Typography variant='h4'>BBYH69</Typography>
            <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                <Grid item xs={1}>
                    <VerifiedIcon />
                </Grid>
                <Grid item xs={6} sx={{ paddingLeft: '0px !important' }}>
                    <Typography  > TOYOTA </Typography>
                </Grid>
            </Grid>

            <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                <Grid item xs={1}>
                    < VerifiedIcon />
                </Grid>
                <Grid item xs={6} sx={{ paddingLeft: '0px !important' }}>
                    <Typography variant='body1'>YARIS</Typography>
                </Grid>
            </Grid>
            <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                <Grid item xs={1}>
                    <VerifiedIcon color='primary' />
                </Grid>
                <Grid item xs={6} sx={{ paddingLeft: '0px !important' }}>
                    <Typography variant='body1' > Sedan </Typography>
                </Grid>
            </Grid>

            <Button variant="contained" sx={{ margin: 2 }}> Add Card</Button>
        </Box>

        <Box sx={{ mr: 2 }} component="p">
            $20.000
        </Box>



    </Paper>

}