## Plants

### Retrieve a specific plant

`GET` `/plants/{plantId}`

#### Response

```typescript
interface GetPlantResponse {
    id: string
    date: string
    name: string
    type: string
}
```

### Retrieve all plants

`GET` `/plants`

#### Response

```typescript
Array<GetPlantResponse>
```


## Journal Entries

### Submit all journal entries

`POST` `journal-entries`

```typescript
interface JournalEntryRequest {
  plantId: string
  createdAt: string
  type: string
  data: string,
  dataUrl: string
}
```

`GET` `/api/journal-entries`

#### Query parameters

 * `plantId: string` - ID of the plant this entry belongs to
 * `_sort=createdAt` - Sorts the entries retrieved by date created
 * `_order=desc` - sorts the entries in descending order
 * `type=image` - filters only the image types

#### Request

```typescript
interface JournalEntryResponse {
  id: string  
  plantId: string
  createdAt: string
  type: string
  data: string,
  dataUrl: string
}
```

#### Response

```typescript
Array<JournalEntryResponse>
```
#### Delete single plant
`DELETE` `/plants/${id}`
