**1** crear carpeta:

webstorm -> vite -> elegir carpeta -> template: vue -> no marcar y crear

**2** ingresar comandos:
```
npm install -g json-server@0.17.4
```
**3** Generar la parte del server:
db.json y routes.json
```
{
  {
  "buses": [
    {
      "id": 1,
      "vehiclePlate": "ABC-1234",
      "fuelTankType": "Type A",
      "districtId": 1,
      "totalSeats": 20
    },
    {
      "id": 2,
      "vehiclePlate": "XYZ-5678",
      "fuelTankType": "Type B",
      "districtId": 1,
      "totalSeats": 25
    },
    {
      "id": 3,
      "vehiclePlate": "LMN-9012",
      "fuelTankType": "Type C",
      "districtId": 2,
      "totalSeats": 30
    },
    {
      "id": 4,
      "vehiclePlate": "PQR-3456",
      "fuelTankType": "Type D",
      "districtId": 2,
      "totalSeats": 40
    },
    {
      "id": 5,
      "vehiclePlate": "STU-7890",
      "fuelTankType": "Type A",
      "districtId": 3,
      "totalSeats": 22
    },
    {
      "id": 6,
      "vehiclePlate": "VWX-2345",
      "fuelTankType": "Type C",
      "districtId": 3,
      "totalSeats": 35
    }
  ],
  "students": [
    {
      "id": 1,
      "firstName": "Emma",
      "lastName": "Smith",
      "districtId": 1,
      "parentId": 101
    },
    {
      "id": 2,
      "firstName": "Liam",
      "lastName": "Smith",
      "districtId": 1,
      "parentId": 101
    },
    {
      "id": 3,
      "firstName": "Olivia",
      "lastName": "Johnson",
      "districtId": 1,
      "parentId": 102
    },
    {
      "id": 4,
      "firstName": "Noah",
      "lastName": "Johnson",
      "districtId": 1,
      "parentId": 102
    },
    {
      "id": 5,
      "firstName": "Ava",
      "lastName": "Wilson",
      "districtId": 2,
      "parentId": 103
    },
    {
      "id": 6,
      "firstName": "James",
      "lastName": "Wilson",
      "districtId": 2,
      "parentId": 103
    },
    {
      "id": 7,
      "firstName": "Sophia",
      "lastName": "Anderson",
      "districtId": 2,
      "parentId": 104
    },
    {
      "id": 8,
      "firstName": "William",
      "lastName": "Anderson",
      "districtId": 2,
      "parentId": 104
    },
    {
      "id": 9,
      "firstName": "Isabella",
      "lastName": "Jackson",
      "districtId": 3,
      "parentId": 105
    },
    {
      "id": 10,
      "firstName": "Lucas",
      "lastName": "Jackson",
      "districtId": 3,
      "parentId": 105
    },
    {
      "id": 11,
      "firstName": "Mia",
      "lastName": "Harris",
      "districtId": 3,
      "parentId": 106
    },
    {
      "id": 12,
      "firstName": "Henry",
      "lastName": "Harris",
      "districtId": 3,
      "parentId": 106
    },
    {
      "id": 13,
      "firstName": "Charlotte",
      "lastName": "Lee",
      "districtId": 1,
      "parentId": 107
    },
    {
      "id": 14,
      "firstName": "Ethan",
      "lastName": "Walker",
      "districtId": 2,
      "parentId": 108
    },
    {
      "id": 15,
      "firstName": "Amelia",
      "lastName": "Walker",
      "districtId": 2,
      "parentId": 108
    }
  ],
  "assignments": [
    {
      "id": 1,
      "studentId": 1,
      "busId": 1,
      "assignedAt": "2025-05-01T08:00:00Z"
    },
    {
      "id": 2,
      "studentId": 2,
      "busId": 1,
      "assignedAt": "2025-05-01T08:00:00Z"
    },
    {
      "id": 3,
      "studentId": 3,
      "busId": 1,
      "assignedAt": "2025-05-02T09:00:00Z"
    },
    {
      "id": 4,
      "studentId": 4,
      "busId": 1,
      "assignedAt": "2025-05-02T09:00:00Z"
    },
    {
      "id": 5,
      "studentId": 5,
      "busId": 3,
      "assignedAt": "2025-05-03T10:00:00Z"
    },
    {
      "id": 6,
      "studentId": 6,
      "busId": 3,
      "assignedAt": "2025-05-03T10:00:00Z"
    },
    {
      "id": 7,
      "studentId": 7,
      "busId": 3,
      "assignedAt": "2025-05-04T11:00:00Z"
    },
    {
      "id": 8,
      "studentId": 8,
      "busId": 3,
      "assignedAt": "2025-05-04T11:00:00Z"
    },
    {
      "id": 9,
      "studentId": 9,
      "busId": 5,
      "assignedAt": "2025-05-05T12:00:00Z"
    },
    {
      "studentId": 10,
      "busId": 5,
      "assignedAt": "2025-05-23T03:05:54.474Z",
      "id": 10
    }
  ]
}
```
```
{
  "/api/v1/*": "/$1"
}
```
**4** Generar los demas comandos:
```
npm install vue-i18n@10
```
```
npm i primevue @primeuix/themes primeicons primeflex
```
```
npm install primevue @primeuix/themes
```
```
npm install primeflex
```
```
npm install primeicons
```
**5** Generar carpetas en src:
-firstudent:domain, services
-locales
-public:components, pages
-router

**6** domain:
firststudents
assignment.domain.js
4 naranjas
```
export function validateAssignment({ student, bus, assignments, students }) {
  if (!student) return 'invalidStudent';
  if (!bus) return 'invalidBus';
  if (student.districtId !== bus.districtId) return 'invalidBus';
  if (assignments.some(a => a.studentId === student.id)) return 'alreadyAssigned';
 //logica de form
  const siblings = students.filter(s => s.parentId === student.parentId);
  const siblingAssignments = assignments.filter(a => siblings.some(s => s.id === a.studentId));
  if (siblingAssignments.length > 0 && siblingAssignments[0].busId !== bus.id) {
    return 'siblingBus';
  }
  return null;
}
```
**7** services:
assignment.service.js
```

export async function fetchAllData() {
  const [studentsRes, busesRes, assignmentsRes] = await Promise.all([
    fetch('http://localhost:3000/students'),
    fetch('http://localhost:3000/buses'),
    fetch('http://localhost:3000/assignments')
  ]);
  return {
    students: await studentsRes.json(),
    buses: await busesRes.json(),
    assignments: await assignmentsRes.json()
  };
}
//crear asignacion de bus y estudiante

export async function createAssignment({ studentId, busId }) {
  return fetch('http://localhost:3000/assignments', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      studentId,
      busId,
      assignedAt: new Date().toISOString()
    })
  });
}
```


bus.service.js
1 naranja
```
export async function fetchBusesWithAvailableSeats() {


  const [busesRes, assignmentsRes] = await Promise.all([
    fetch('http://localhost:3000/buses'),
    fetch('http://localhost:3000/assignments')
  ]);
  const buses = await busesRes.json();
  const assignments = await assignmentsRes.json();


  const assignmentsCount = {};
  assignments.forEach(a => {
    assignmentsCount[a.busId] = (assignmentsCount[a.busId] || 0) + 1;
  });


  //contandor de asientos ocupados
  return buses.map(bus => ({
    ...bus,
    occupiedSeats: assignmentsCount[bus.id] || 0,
    availableSeats: bus.totalSeats - (assignmentsCount[bus.id] || 0)
  }));
}
```
**8** locales:
en.json
```
{
  "home": {
    "welcome": "Welcome to FIRSTstudent!",
    "buses": "Buses",
    "plate": "Plate",
    "fuelTank": "Fuel Tank",
    "totalSeats": "Total Seats",
    "occupiedSeats": "Occupied Seats",
    "availableSeats": "Available Seats"
  },
  "footer": {
    "copyright": "Copyright © 2025.",
    "designer": "Designer Mathias Aspajo u202317584"
  },
  "pagenotfound": {
    "title": "Page Not Found",
    "back-home": "Back to Home"
  },
  "toolbar": {
    "trusted": "Trusted student transportation"
  },

  "option": {
    "home": "Home",
    "assignments": "Assignments"
  },
  "assignments": {
    "title": "Assign Student to Bus",
    "new": "New Assignment",
    "studentId": "Student Id",
    "busId": "Bus Id",
    "assign": "Assign",
    "required": "Both fields are required.",
    "invalidStudent": "Invalid Student Id",
    "invalidBus": "Invalid Bus",
    "alreadyAssigned": "Already Assigned",
    "siblingBus": "Siblings must be assigned to the same bus.",
    "success": "Assignment registered successfully.",
    "error": "An error occurred. Please try again."
  }

}
```
es.json
```
{
  "home": {
    "welcome": "¡Bienvenido FIRSTstudent",
    "buses": "Buses",
    "plate": "Placa",
    "fuelTank": "Tipo de tanque",
    "totalSeats": "Asientos totales",
    "occupiedSeats": "Asientos ocupados",
    "availableSeats": "Asientos disponibles"
  },
  "footer": {
    "copyright": "Copyright © 2025",
    "designer": "Creador Mathias Aspajo u202317584"
  },
  "pagenotfound": {
    "title": "Página no encontrada",
    "back-home": "Volver al inicio"
  },
  "toolbar": {
    "trusted": "Transporte estudiantil confiable"
  },

  "option": {
    "home": "Inicio",
    "assignments": "Asignaciones"
  },
  "assignments": {
    "title": "Asignar estudiante a bus",
    "new": "Nueva asignación",
    "studentId": "Id de estudiante",
    "busId": "Id de bus",
    "assign": "Asignar",
    "required": "Ambos campos son obligatorios.",
    "invalidStudent": "Id de estudiante inválido",
    "invalidBus": "Bus inválido",
    "alreadyAssigned": "Ya asignado",
    "siblingBus": "Los hermanos deben estar asignados al mismo bus.",
    "success": "Asignación registrada exitosamente.",
    "error": "Ocurrió un error. Inténtalo de nuevo."
  }
}
```
**9** components:
public
footer-content.component.vue
2 naranjas
```
<script>
export default {
  name: "footer-content"
}
</script>

<template>
  <div class="grid bg-primary mt-4 p-2 align-content-start">
    <div class="col-12 ml-3 align-items-center justify-content-center">
      <p>{{ $t('footer.copyright') }}</p>
      <p>{{ $t('footer.designer') }}</p>
    </div>
  </div>
</template>

<style scoped>

</style>
```
language-switcher.component.vue
1 amarillo 2 naranjas
```
<script>
import {SelectButton as PvSelectButton} from "primevue";
export default {
  name: "language-switcher",
  data() {
    return {
      languages: []
    }
  },
  created() {
    this.languages = this.$i18n.availableLocales;
  }
}
</script>

<template>
  <pv-select-button v-model="$i18n.locale" :options="languages">
    <template #option="slotProps">
      {{ slotProps.option.toUpperCase()}}
    </template>
  </pv-select-button>
</template>

<style scoped>

</style>
```
**9** pages:
assignments.component.vue
5 naranjas
```
<script>
import { fetchAllData, createAssignment } from '../../firststudent/services/assignment.service.js';
import { validateAssignment } from '../../firststudent/domain/assignment.domain.js';

export default {
  name: "assignments-component",
  data() {
    return {
      studentId: '',
      busId: '',
      error: '',
      success: '',
      loading: false
    }
  },
  methods: {
    async assignStudent() {
      this.error = '';
      this.success = '';

      if (
        !this.studentId ||
        !this.busId ||
        isNaN(this.studentId) ||
        isNaN(this.busId) ||
        this.studentId < 1 ||
        this.busId < 1
      ) {
        this.error = this.$t('assignments.required');
        return;
      }

      this.loading = true;
      try {
        const { students, buses, assignments } = await fetchAllData();
        if (!students.length) {
          this.error = this.$t('assignments.error') + ' (No students found)';
          this.loading = false;
          return;
        }
        if (!buses.length) {
          this.error = this.$t('assignments.error') + ' (No buses found)';
          this.loading = false;
          return;
        }
        const student = students.find(s => s.id === Number(this.studentId));
        const bus = buses.find(b => b.id === Number(this.busId));
        const errorKey = validateAssignment({ student, bus, assignments, students });
        if (errorKey) {
          this.error = this.$t(`assignments.${errorKey}`);
          this.loading = false;
          return;
        }
        try {
          await createAssignment({ studentId: student.id, busId: bus.id });
          this.success = this.$t('assignments.success');
          this.studentId = '';
          this.busId = '';
        } catch (e) {
          this.error = this.$t('assignments.error') + ' (Failed to create assignment)';
        }
      } catch (e) {
        this.error = this.$t('assignments.error') + ' (API unreachable)';
      }
      this.loading = false;
    }
  }
}
</script>

<template>
  <div class="assignment-page">
    <h1>{{ $t('assignments.title') }}</h1>
    <section>
      <h2>{{ $t('assignments.new') }}</h2>
      <div class="assignment-card">

        <form @submit.prevent="assignStudent" class="assignment-form">
          <div class="form-group">
            <label for="studentId">{{ $t('assignments.studentId') }}</label>
            <input
              id="studentId"
              v-model.number="studentId"
              type="number"
              min="1"
              :disabled="loading"
              autocomplete="off"
              required
            />
          </div>
          <div class="form-group">
            <label for="busId">{{ $t('assignments.busId') }}</label>
            <input
              id="busId"
              v-model.number="busId"
              type="number"
              min="1"
              :disabled="loading"
              autocomplete="off"
              required
            />
          </div>
          <pv-button type="submit" :disabled="loading" class="assign-btn">
            {{ $t('assignments.assign') }}
          </pv-button>
        </form>

        <div v-if="error" class="form-message error">{{ error }}</div>
        <div v-if="success" class="form-message success">{{ success }}</div>
      </div>
    </section>
  </div>
</template>

<style scoped>
.assignment-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  color: var(--primary-text);
}

.assignment-card {
  background: var(--secondary-bg);
  border-radius: 12px;
  box-shadow: 0 2px 16px rgba(0,0,0,0.4);
  padding: 2em 2.5em 2em 2.5em;
  margin-top: 1.5em;
  min-width: 320px;
  max-width: 400px;
  width: 100%;
}

.assignment-form {
  display: flex;
  flex-direction: column;
  gap: 1.5em;
}

.form-group {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.assignment-form label {
  color: var(--primary-text);
  font-weight: 500;
  margin-bottom: 0.5em;
}

.assignment-form input {
  background: var(--input-bg);
  color: var(--primary-text);
  border: 1px solid var(--input-border);
  border-radius: 6px;
  padding: 0.6em 0.8em;
  font-size: 1em;
  width: 100%;
  transition: border 0.2s;
}

.assignment-form input:focus {
  outline: 2px solid var(--accent);
  border-color: var(--accent);
}

.assign-btn {
  margin-top: 0.5em;
  width: 100%;
  background: var(--button-bg);
  color: var(--primary-text);
  border: 1px solid var(--input-border);
  border-radius: 6px;
  font-weight: 600;
  font-size: 1em;
  padding: 0.7em 0;
  transition: background 0.2s, border 0.2s;
}

.assign-btn:hover {
  background: var(--button-hover);
  border-color: var(--accent);
}

.form-message {
  margin-top: 1.2em;
  padding: 0.8em 1em;
  border-radius: 6px;
  font-size: 1em;
  text-align: center;
}

.form-message.error {
  background: #2d1a1a;
  color: #ff6b6b;
  border: 1px solid #ff6b6b;
}

.form-message.success {
  background: #1a2d1a;
  color: #51ff8a;
  border: 1px solid #51ff8a;
}
</style>
```
```
<script>
import { fetchAllData, createAssignment } from '../../firststudent/services/assignment.service.js';
import { validateAssignment } from '../../firststudent/domain/assignment.domain.js';

export default {
  name: "assignments-component",
  data() {
    return {
      studentId: '',
      busId: '',
      error: '',
      success: '',
      loading: false
    }
  },
  methods: {
    async assignStudent() {
      this.error = '';
      this.success = '';

      if (
        !this.studentId ||
        !this.busId ||
        isNaN(this.studentId) ||
        isNaN(this.busId) ||
        this.studentId < 1 ||
        this.busId < 1
      ) {
        this.error = this.$t('assignments.required');
        return;
      }

      this.loading = true;
      try {
        const { students, buses, assignments } = await fetchAllData();
        if (!students.length) {
          this.error = this.$t('assignments.error') + '(No students found)';
          this.loading = false;
          return;
        }
        if (!buses.length) {
          this.error = this.$t('assignments.error') + ' (No buses found)';
          this.loading = false;
          return;
        }
        const student = students.find(s => s.id === Number(this.studentId));
        const bus = buses.find(b => b.id === Number(this.busId));
        const errorKey = validateAssignment({ student, bus, assignments, students });
        if (errorKey) {
          this.error = this.$t(`assignments.${errorKey}`);
          this.loading = false;
          return;
        }
        try {
          await createAssignment({ studentId: student.id, busId: bus.id });
          this.success = this.$t('assignments.success');
          this.studentId = '';
          this.busId = '';
        } catch (e) {
          this.error = this.$t('assignments.error') + ' (Failed to create assignment)';
        }
      } catch (e) {
        this.error = this.$t('assignments.error') + ' (API unreachable)';
      }
      this.loading = false;
    }
  }
}
</script>

<template>
  <div class="assignment-page">
    <h1>{{ $t('assignments.title') }}</h1>
    <section>
      <h2>{{ $t('assignments.new') }}</h2>
      <div class="assignment-card">

        <form @submit.prevent="assignStudent" class="assignment-form">
          <div class="form-group">
            <label for="studentId">{{ $t('assignments.studentId') }}</label>
            <input
              id="studentId"
              v-model.number="studentId"
              type="number"
              min="1"
              :disabled="loading"
              autocomplete="off"
              required
            />
          </div>
          <div class="form-group">
            <label for="busId">{{ $t('assignments.busId') }}</label>
            <input
              id="busId"
              v-model.number="busId"
              type="number"
              min="1"
              :disabled="loading"
              autocomplete="off"
              required
            />
          </div>
          <pv-button type="submit" :disabled="loading" class="assign-btn">
            {{ $t('assignments.assign') }}
          </pv-button>
        </form>

        <div v-if="error" class="form-message error">{{ error }}</div>
        <div v-if="success" class="form-message success">{{ success }}</div>
      </div>
    </section>
  </div>
</template>


<style scoped>
.assignment-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  color: var(--primary-text);
}

.assignment-card {
  background: var(--secondary-bg);
  border-radius: 12px;
  box-shadow: 0 2px 16px rgba(0,0,0,0.4);
  padding: 2em 2.5em 2em 2.5em;
  margin-top: 1.5em;
  min-width: 320px;
  max-width: 400px;
  width: 100%;
}

.assignment-form {
  display: flex;
  flex-direction: column;
  gap: 1.5em;
}

.form-group {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.assignment-form label {
  color: var(--primary-text);
  font-weight: 500;
  margin-bottom: 0.5em;
}

.assignment-form input {
  background: var(--input-bg);
  color: var(--primary-text);
  border: 1px solid var(--input-border);
  border-radius: 6px;
  padding: 0.6em 0.8em;
  font-size: 1em;
  width: 100%;
  transition: border 0.2s;
}

.assignment-form input:focus {
  outline: 2px solid var(--accent);
  border-color: var(--accent);
}

.assign-btn {
  margin-top: 0.5em;
  width: 100%;
  background: var(--button-bg);
  color: var(--primary-text);
  border: 1px solid var(--input-border);
  border-radius: 6px;
  font-weight: 600;
  font-size: 1em;
  padding: 0.7em 0;
  transition: background 0.2s, border 0.2s;
}

.assign-btn:hover {
  background: var(--button-hover);
  border-color: var(--accent);
}

.form-message {
  margin-top: 1.2em;
  padding: 0.8em 1em;
  border-radius: 6px;
  font-size: 1em;
  text-align: center;
}

.form-message.error {
  background: #2d1a1a;
  color: #ff6b6b;
  border: 1px solid #ff6b6b;
}

.form-message.success {
  background: #1a2d1a;
  color: #51ff8a;
  border: 1px solid #51ff8a;
}
</style>
```
home.component.vue
8 naranjas
```
<script>
import { fetchBusesWithAvailableSeats } from '../../firststudent/services/bus.service.js';

export default {
  name: "home-component",
  data() {
    return {
      buses: [],
      loading: false,
      first: 0,
      rows: 5,
      sortField: null,
      sortOrder: null,
      error: ''
    }
  },
  async created() {
    this.loading = true;
    try {
      this.buses = await fetchBusesWithAvailableSeats();
    } catch (e) {
      this.error = this.$t('assignments.error') + ' (API unreachable)';
    }
    this.loading = false;
  },
  computed: {
    pagedBuses() {
      let sorted = [...this.buses];
      if (this.sortField) {
        sorted.sort((a, b) => {
          const valA = a[this.sortField];
          const valB = b[this.sortField];
          if (valA < valB) return this.sortOrder === 1 ? -1 : 1;
          if (valA > valB) return this.sortOrder === 1 ? 1 : -1;
          return 0;
        });
      }
      return sorted.slice(this.first, this.first + this.rows);
    }
  },
  methods: {
    onPage(event) {
      this.first = event.first;
      this.rows = event.rows;
    },
    onSort(event) {
      this.sortField = event.sortField;
      this.sortOrder = event.sortOrder;
    }
  }
}
</script>

<template>
  <div>
    <h1>{{ $t('option.home') }}</h1>
    <p>{{ $t('home.welcome') }}</p>
    <section>
      <h2>{{ $t('home.buses') }}</h2>
      <div v-if="error" class="form-message error">{{ error }}</div>
      <pv-data-table
          v-else
          :value="pagedBuses"
          :paginator="true"
          :rows="rows"
          :totalRecords="buses.length"
          :loading="loading"
          :first="first"
          @page="onPage"
          :sortField="sortField"
          :sortOrder="sortOrder"
          @sort="onSort"
          dataKey="id"
      >
        <pv-column field="vehiclePlate" :header="$t('home.plate')" sortable></pv-column>
        <pv-column field="fuelTankType" :header="$t('home.fuelTank')" sortable></pv-column>
        <pv-column field="totalSeats" :header="$t('home.totalSeats')" sortable></pv-column>
        <pv-column field="occupiedSeats" :header="$t('home.occupiedSeats')" sortable></pv-column>
        <pv-column field="availableSeats" :header="$t('home.availableSeats')" sortable></pv-column>
      </pv-data-table>
    </section>
  </div>
</template>

<style scoped>
section {
  margin-top: 2rem;
}
.form-message.error {
  background: #2d1a1a;
  color: #ff6b6b;
  border: 1px solid #ff6b6b;
  margin-top: 1.2em;
  padding: 0.8em 1em;
  border-radius: 6px;
  font-size: 1em;
  text-align: center;
}
</style>
```
page-not-found.component.vue
2 naranjas
```
<script>
export default {
  name: "page-not-found",
  data() {
    return {
      unavailableRoute: null,
    }
  },
  created() {
    this.unavailableRoute = this.$route.path;
  }
}


</script>

<template>
  <div class="w-full">

    <h1>{{$t('pagenotfound.title')}}</h1>

    <p>The path <b>{{ unavailableRoute }}</b> is not available.</p>

    <router-link to="/home">{{$t('pagenotfound.back-home')}}</router-link>
  </div>
</template>

<style scoped>

</style>
```
**9** router:
index.js
```
import HomeComponent from "../public/pages/home.component.vue";
const PageNotFoundComponent = () => import('../public/pages/page-not-found.component.vue');
import AssignmentsComponent from "../public/pages/assignments.component.vue";

import {createRouter, createWebHistory} from "vue-router";

const routes = [
  { path: '/home', name: 'home', component: HomeComponent, meta: { title: 'Home' } },
  { path: '/transportation/assignments/new', name: 'assignments-new', component: AssignmentsComponent, meta: { title: 'Assignments' } },
  { path: '/', name: 'default', redirect: '/home' },
  { path: '/:pathMatch(.*)*', name: 'not-found', component: PageNotFoundComponent, meta: { title: 'Page not found' } },
];

const router = createRouter({
    history: createWebHistory(import.meta.BASE_URL),
    routes: routes,
});

router.beforeEach((to, from, next) => {
    let baseTitle = 'FIRSTstudent';
    document.title = `${baseTitle} | ${to.meta['title']}`;
    next();
});

export default router;
```
**10** app.vue:
4 naranjas
```
<script>
import LanguageSwitcher from "./public/components/language-switcher.component.vue";
import FooterContent from "./public/components/footer-content.component.vue";
export default {
  name: 'app',
  components: {FooterContent, LanguageSwitcher},
  data() {
    return {
      drawer: false,
      items: [
        { label: 'option.home', to: '/home' },
        { label: 'option.assignments', to: '/transportation/assignments/new' }
      ]
    }
  },
  methods: {
    toggleDrawer() {
      this.drawer = !this.drawer;
    }
  }
}
</script>

<template>
  <pv-toast/>
  <pv-confirm-dialog/>
  <header>
    <pv-toolbar class="bg-primary">
      <template #start>
        <div class="toolbar-left" style="display: flex; align-items: center;">
          <button
              class="hamburger"
              :class="{ open: drawer }"
              @click="toggleDrawer"
              aria-label="Menu"
          >
            <span></span><span></span><span></span>
          </button>
          <img
              src="https://logo.clearbit.com/firststudentinc.com"
              alt="FIRSTstudent Logo"
              style="height: 40px; margin-right: 1rem;"
          />
          <span style="font-weight: 500; font-size: 1.1rem;">{{ $t('toolbar.trusted') }}</span>
        </div>
      </template>
      <template #center>
        <div class="flex-column nav-links">
          <pv-button v-for="item in items" :key="item.label" as-child v-slot="slotProps">
            <router-link :to="item.to" :class="slotProps['class']">{{ $t(item.label)}}</router-link>
          </pv-button>
        </div>
      </template>
      <template #end>
        <language-switcher/>
      </template>
    </pv-toolbar>
    <pv-drawer v-model:visible="drawer" position="left">
      <nav class="drawer-links">
        <pv-button
            v-for="item in items"
            :key="item.label"
            as-child
            class="drawer-link-btn"
            :class="{ active: $route.path === item.to }"
            @click="drawer = false"
        >
          <router-link :to="item.to" class="drawer-link-content">
            <i :class="item.icon" class="drawer-link-icon"></i>
            <span>{{ $t(item.label) }}</span>
          </router-link>
        </pv-button>
      </nav>
    </pv-drawer>

  </header>
  <main>
    <router-view/>
  </main>
  <footer>
    <footer-content/>
  </footer>
</template>

<style scoped>
.hamburger {
  display: none;
  flex-direction: column;
  justify-content: center;
  width: 36px;
  height: 36px;
  background: none;
  border: none;
  margin-right: 1rem;
  cursor: pointer;
  padding: 0;
  z-index: 1001;
  transition: background 0.2s;
}
.hamburger span {
  display: block;
  height: 4px;
  width: 24px;
  background: var(--primary-text);
  margin: 3px 0;
  border-radius: 2px;
  transition: 0.3s;
}
.hamburger.open span:nth-child(1) {
  transform: translateY(7px) rotate(45deg);
}
.hamburger.open span:nth-child(2) {
  opacity: 0;
}
.hamburger.open span:nth-child(3) {
  transform: translateY(-7px) rotate(-45deg);
}
@media (max-width: 700px) {
  .nav-links {
    display: none;
  }
  .hamburger {
    display: flex;
  }
}

.drawer-links {
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
  padding: 2rem 1.5rem;
  min-width: 200px;
  background: var(--secondary-bg);
  height: 100%;
  justify-content: flex-start;
  align-items: flex-start;
}
.drawer-link-btn {
  width: 100%;
  text-align: left;
  background: none;
  border: none;
  color: var(--primary-text);
  font-size: 1.13rem;
  font-weight: 600;
  padding: 0;
  border-radius: 8px;
  transition: background 0.2s, color 0.2s, box-shadow 0.2s;
}
.drawer-link-btn .drawer-link-content {
  display: flex;
  align-items: center;
  gap: 0.9em;
  width: 100%;
  padding: 0.85em 0.7em;
  border-radius: 8px;
  text-decoration: none;
  color: inherit;
  transition: background 0.2s, color 0.2s;
}
.drawer-link-btn .drawer-link-icon {
  font-size: 1.3em;
  color: var(--accent);
}
.drawer-link-btn:hover .drawer-link-content,
.drawer-link-btn:focus .drawer-link-content {
  background: var(--button-hover);
  color: var(--accent);
  box-shadow: 0 2px 8px rgba(100,108,255,0.08);
}
.drawer-link-btn.active .drawer-link-content {
  background: var(--accent);
  color: #fff;
  box-shadow: 0 2px 12px rgba(100,108,255,0.15);
}
.drawer-link-btn.active .drawer-link-icon {
  color: #fff;
}
</style>
```
**11** i18n.js:
```
import en from './locales/en.json';
import es from './locales/es.json';
import {createI18n} from "vue-i18n";

const i18n = createI18n({
    locale: 'en',
    fallbackLocale: 'en',
    globalInjection: true,
    messages: { en, es }
});

export default i18n;
```
**12** main.js:
1 naranja
```
import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

import {PrimeVue} from '@primevue/core';
import 'primeflex/primeflex.css';
import 'primeicons/primeicons.css';
import Material from '@primeuix/themes/material';
import {
    Button,
    Card,
    Checkbox,
    Column, ConfirmationService,
    ConfirmDialog,
    DataTable,
    Dialog, DialogService, Drawer,
    FileUpload, FloatLabel, IconField, InputIcon, InputNumber, InputText, Menu, Rating, Row,
    Select,
    SelectButton, Tag, Textarea, Toast, ToastService, Toolbar
} from "primevue";
import i18n from "./i18n.js";
import router from "./router/index.js";

createApp(App)
    .use(i18n)
    .use(router)
    .use(PrimeVue, { theme: { preset: Material}, ripple: true})
    .use(ConfirmationService)
    .use(DialogService)
    .use(ToastService)
    .component('pv-button', Button)
    .component('pv-card', Card)
    .component('pv-column', Column)
    .component('pv-confirm-dialog', ConfirmDialog)
    .component('pv-checkbox', Checkbox)
    .component('pv-data-table', DataTable)
    .component('pv-dialog', Dialog)
    .component('pv-select', Select)
    .component('pv-select-button', SelectButton)
    .component('pv-file-upload', FileUpload)
    .component('pv-float-label', FloatLabel)
    .component('pv-icon-field', IconField)
    .component('pv-input-icon', InputIcon)
    .component('pv-input-text', InputText)
    .component('pv-input-number', InputNumber)
    .component('pv-menu', Menu)
    .component('pv-rating', Rating)
    .component('pv-row', Row)
    .component('pv-drawer', Drawer)
    .component('pv-tag', Tag)
    .component('pv-textarea', Textarea)
    .component('pv-toolbar', Toolbar)
    .component('pv-toast', Toast)
    .mount('#app')
```
**13** style.css:
```
:root {
  --primary-bg: #181a20;
  --secondary-bg: #23272f;
  --primary-text: #f5f6fa;
  --secondary-text: #b0b3b8;
  --accent: #646cff;
  --button-bg: #23272f;
  --button-hover: #353945;
  --input-bg: #23272f;
  --input-border: #353945;

  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  color-scheme: dark;
  color: var(--primary-text);
  background-color: var(--primary-bg);
}

body {
  margin: 0;
  min-width: 320px;
  min-height: 100vh;
  background: var(--primary-bg);
  color: var(--primary-text);
}

#app {
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
  background: var(--secondary-bg);
  border-radius: 12px;
  box-shadow: 0 2px 16px rgba(0,0,0,0.4);
}

a {
  color: var(--accent);
}
a:hover {
  color: #8a8cff;
}

h1, h2, h3, h4, h5, h6 {
  color: var(--primary-text);
}

button, .pv-button {
  background: var(--button-bg);
  color: var(--primary-text);
  border: 1px solid var(--input-border);
}
button:hover, .pv-button:hover {
  background: var(--button-hover);
  border-color: var(--accent);
}

input, .assignment-form input, .pv-input-text {
  background: var(--input-bg);
  color: var(--primary-text);
  border: 1px solid var(--input-border);
}
input:focus, .assignment-form input:focus, .pv-input-text:focus {
  outline: 2px solid var(--accent);
}

.card, .pv-card {
  background: var(--secondary-bg);
  color: var(--primary-text);
  border-radius: 8px;
  box-shadow: 0 1px 8px rgba(0,0,0,0.3);
}

footer, header, .pv-toolbar, .pv-drawer {
  background: var(--secondary-bg) !important;
  color: var(--primary-text) !important;
}

@media (prefers-color-scheme: light) {
  :root {
    color-scheme: dark;
    color: var(--primary-text);
    background-color: var(--primary-bg);
  }
}
```
revisar y agregar los componentes q faltan en las carpetas antes de iniciar

```
json-server --watch server/db.json --routes server/routes.json
```









